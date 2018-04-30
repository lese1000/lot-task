package com.tp.lottery.task;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tp.lottery.service.entity.JoinBuy;
import com.tp.lottery.service.entity.JoinBuyDetail;
import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.entity.Order;
import com.tp.lottery.service.entity.OrderDetail;
import com.tp.lottery.service.entity.Rule;
import com.tp.lottery.service.service.BalanceService;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.service.service.OrderService;
import com.tp.lottery.util.WinNumber;

@Component
public class OpenPrizeTask {
	
	private Logger logger = LoggerFactory.getLogger(OpenPrizeTask.class);
	
	@Autowired
	private OrderService orderService; 
	@Autowired
	private LotteryNumService lotteryNumService;
	@Autowired
	private BalanceService balanceService;
	
//	@Scheduled(cron="0 0/10 * * * ?")
	@Scheduled(fixedDelay = 10*60*1000)  
	public void openPrize() {
		logger.info(">> 开奖定时任务启动 <<");
		try {
			//1) 获取需要开奖的期号
			List<LotteryNumEntity> lotteryNumList = lotteryNumService.listLotteryByOpenTime();
			logger.info(">>1）：共有 ："+ lotteryNumList.size() + "期号需要开奖");
			if(null != lotteryNumList) {
				Order orderParam = new Order();
				for(LotteryNumEntity lotteryNum : lotteryNumList) {
					orderParam.setLotteryNumId(lotteryNum.getId());
					orderParam.setOrderStatus((byte)0);//取未开奖的期号
					List<Order> orderList = orderService.listOrderSelective(orderParam);
					if(null != orderList) {
						for(Order order : orderList) {
							Rule rule = orderService.getRuleByRuleId(order.getRuleId());
								List<OrderDetail> orderDetailList = orderService.listOrderDetailByOrderId(order.getId());
								if(null != orderDetailList) {
									//2)计算中奖明细
									double totalWinPrize = 0d;
									for(OrderDetail orderDetail : orderDetailList) {
										int winCount = 0;//中奖注数
										double winPrize = 0d;
										List<String> bettingNumList = Arrays.asList(orderDetail.getBettingNum().split(","));
										String [] winNums = lotteryNum.getWinNum().split(",");
								    		if(rule.getPlayType() == 0){
								    			winCount=WinNumber.getWinningNumbersByOptional(bettingNumList, winNums, (int) rule.getSelectNumber());
								    		}else if(rule.getPlayType() == 1){
								    			winCount=WinNumber.getWinningNumbersByGroup(bettingNumList, winNums, (int) rule.getSelectNumber());
								    		}else if(rule.getPlayType() == 2){
								    			winCount=WinNumber.getWinningNumbersByStraight(bettingNumList, winNums, (int) rule.getSelectNumber());
								    		}
								    		winPrize = rule.getWinPrize() * orderDetail.getRate() * winCount;
								    		orderDetail.setWinPrize(winPrize);
								    		//更新单个中奖金额
								    		orderService.updateOrderDetailWinPrize2(orderDetail);
								    		//计算总中奖金额
								    		totalWinPrize +=  winPrize;
									}
									//更新订单总中奖金额和状态
									order.setTotalWinMoney(totalWinPrize);
									byte orderStatus = 2;//未中奖
									if(totalWinPrize > 0) {
										orderStatus = 1;//已中奖
									}
									
									//2）判断是否合买
									if(order.getIsJoinBuy() == 0) {//非合买
										//更新用户账号余额
										if(totalWinPrize > 0) {
											balanceService.savaBalanceForwin(order.getId(), order.getPlayerId(), totalWinPrize);
										}
										
									}else {
										//计算用户占比金额
										JoinBuy joinBuy = orderService.getJoinBuyByOrderId(order.getId());
										List<JoinBuyDetail> joinBuyDetailList = orderService.listJoinBuyDetailByJoinBuyId(joinBuy.getId());
										if(joinBuy.getRemainingPieceNum() == 0) {//合买进度百分百
											
											if(null != joinBuyDetailList) {
												for(JoinBuyDetail joinBuyDetail : joinBuyDetailList) {
													double tmpWinPrize = totalWinPrize * (Math.round((double)joinBuyDetail.getBuyCount() / (double)joinBuy.getTotalPieceNum() * 10000 ) * 0.0001 );
													if(tmpWinPrize > 0) {
														balanceService.savaBalanceForwin(order.getId(), joinBuyDetail.getPlayerId(), tmpWinPrize);
													}
													
													//更新合买详情中奖金额
													joinBuyDetail.setWinPrize(tmpWinPrize);
													orderService.updateJoinBuyDetailWinPrize(joinBuyDetail);
												}
											}
										}else {
											orderStatus = 3;//合买失败，退换购买金额
											order.setTotalWinMoney(0d);
											if(null != joinBuyDetailList) {
												for(JoinBuyDetail joinBuyDetail : joinBuyDetailList) {
													balanceService.savaBalanceForJoinBuyFailed(order.getId(), joinBuyDetail.getPlayerId(), joinBuyDetail.getBuyMoney());;
												}
											}
										}
										
									}
									
									//更新订单总中奖金额和状态
									order.setOrderStatus(orderStatus);
									orderService.updateOrderWinPrize2(order);
									logger.info(">>2）订单号 ："+ order.getOrderNum() + ",中奖金额:" + totalWinPrize);
								}
							
							
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("openPrize Error",e);
		}
	}

}
