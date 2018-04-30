package com.tp.lottery.task;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.lottery.service.entity.JoinBuy;
import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.entity.Order;
import com.tp.lottery.service.entity.OrderDetail;
import com.tp.lottery.service.entity.Rule;
import com.tp.lottery.service.service.BalanceService;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.service.service.OrderService;
import com.tp.lottery.util.WinNumber;

public class OpenPrizeTask2 {
	
	@Autowired
	private OrderService orderService; 
	@Autowired
	private LotteryNumService lotteryNumService;
	@Autowired
	private BalanceService balanceService;
	
	public void openPrize() {
		try {
			//1) 获取需要开奖的期号
			List<LotteryNumEntity> lotteryNumList = lotteryNumService.listLotteryByOpenTime();
			if(null != lotteryNumList) {
				Order orderParam = new Order();
				for(LotteryNumEntity lotteryNum : lotteryNumList) {
					orderParam.setLotteryNumId(lotteryNum.getId());
					List<Order> orderList = orderService.listOrderSelective(orderParam);
					if(null != orderList) {
						for(Order order : orderList) {
							Rule rule = orderService.getRuleByRuleId(order.getRuleId());
							//2）判断是否合买
							if(order.getIsJoinBuy() == 0) {//非合买
								List<OrderDetail> orderDetailList = orderService.listOrderDetailByOrderId(order.getId());
								if(null != orderDetailList) {
									//3)计算中奖明细
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
									order.setOrderStatus(orderStatus);
									orderService.updateOrderWinPrize2(order);
									//更新用户账号余额
									balanceService.savaBalanceForwin(order.getId(), order.getPlayerId(), totalWinPrize);
								}
							}else {
								 JoinBuy joinBuy = orderService.getJoinBuyByOrderId(order.getId());
								//合买失败，退回合买金额
								/* if(joinBuy.getRemainingPieceNum() != 0) {
									 
								 }else {
									 
								 }*/
								 
								
							}
							
						}
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
