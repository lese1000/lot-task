package com.tp.lottery.task;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.service.BalanceService;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.service.service.OrderService;
import com.tp.lottery.util.CombinatorialUtil;
import com.tp.lottery.util.WinNumber;

@Component
public class SendPrizeTask {
	private Logger logger = LoggerFactory.getLogger(SendPrizeTask.class);
	@Autowired
	private LotteryNumService lotteryNumService;
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BalanceService balanceService;
	
//	@Scheduled(cron="0 0/10 * * * ?")
//	@Scheduled(fixedDelay = 10*60*1000)    
    public void GeneratingLotteryNum() {
    	LotteryNumEntity lotteryNum=lotteryNumService.findLotteryByOpenTime();
    	String[] WinNums=lotteryNum.getWinNum().split(",");
    	List<OrderDetailEntity> orderDetailList=orderService.findOrderByLotteryNumId(lotteryNum.getId());
    	long orderId=0l;
    	long playId=0l;
    	Double winPrizeTotal=0d;
    	for(OrderDetailEntity orderDetail:orderDetailList){
	    		if(orderId>0 && orderId!=orderDetail.getOrderId()){
	    			OrderEntity order=new OrderEntity();
	    			order.setId(orderId);
	    			order.setTotalWinMoney(winPrizeTotal);
	    			order.setOrderStatus(1);
	    			orderService.updateOrderWinPrize(order);
	    			if(winPrizeTotal>0){
	    				balanceService.savaBalanceForwin(orderId, playId, winPrizeTotal);
	    			}
	    			winPrizeTotal=0d;
	    		}
	    		orderId=orderDetail.getOrderId();
	    		playId=orderDetail.getPlayerId();
	    		String[] bettingNums=orderDetail.getBettingNum().split(",");
	    		List<String> bettingNumArr = Arrays.asList(bettingNums);
	//    		Long count=0l;
	//    		for(String win:WinNums){
	//    			count += bettingNumArr.stream().filter(string -> string.equals(win)).count();
	//    		}
	//    		int winCount=CombinatorialUtil.getCombinatorial(count.intValue(), 2);
	    		int winCount=0;
	    		if(orderDetail.getPlayType()==0){
	    			winCount=WinNumber.getWinningNumbersByOptional(bettingNumArr, WinNums, orderDetail.getSelectNumber());
	    		}else if(orderDetail.getPlayType()==1){
	    			winCount=WinNumber.getWinningNumbersByGroup(bettingNumArr, WinNums, orderDetail.getSelectNumber());
	    		}else if(orderDetail.getPlayType()==2){
	    			winCount=WinNumber.getWinningNumbersByStraight(bettingNumArr, WinNums, orderDetail.getSelectNumber());
	    		}
	    		if(winCount>0){
	    			orderDetail.setWinPrize(winCount*orderDetail.getWinPrizePrice()*orderDetail.getRate());
	    			winPrizeTotal+=orderDetail.getWinPrize();
	    		}else{
	    			orderDetail.setWinPrize(0d);
	    		}
	    		orderService.updateOrderDetailWinPrize(orderDetail);
   	}
    	
    		OrderEntity order=new OrderEntity();
		order.setId(orderId);
		order.setTotalWinMoney(winPrizeTotal);
		order.setOrderStatus(1);
		orderService.updateOrderWinPrize(order);
		if(winPrizeTotal>0){
			balanceService.savaBalanceForwin(orderId, playId, winPrizeTotal);
		}
    }
	
}
