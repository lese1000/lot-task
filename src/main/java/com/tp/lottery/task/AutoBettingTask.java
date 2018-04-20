package com.tp.lottery.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.service.service.OrderService;
import com.tp.lottery.service.vo.AutoBettingVO;
import com.tp.lottery.util.CombinatorialUtil;
import com.tp.lottery.util.DateUtil;
import com.tp.lottery.util.WinNumber;

@Component
public class AutoBettingTask {
	private Logger logger = LoggerFactory.getLogger(AutoBettingTask.class);
	@Autowired
	private LotteryNumService lotteryNumService;
	@Autowired
	private OrderService orderService;
	
	@Scheduled(cron="0 5/10 * * * ? ")
    public void GeneratingLotteryNum() {
//		 logger.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
    	List<AutoBettingVO> autoDataList=lotteryNumService.findAutoBetting();
    	LotteryNumEntity lotteryNum=lotteryNumService.findLastLottery();
    	for(AutoBettingVO data:autoDataList){
    		for(int n=WinNumber.randomNum(1, 10);n>0;n--){
	    		OrderEntity order=new OrderEntity();
	    		order.setCreateTime(new Date());
	    		order.setIsJoinBuy(0);
	    		order.setLotteryNumId(lotteryNum.getId());
	    		order.setOrderNum("TP"+System.currentTimeMillis());
	    		order.setOrderStatus(0);
	    		order.setPlayerId(data.getPlayId());
	    		order.setRuleId(data.getRuleId());
	    		Double totalBettingMoney=0d;
	    		int num=WinNumber.randomNum(1, 10);
	    		List<OrderDetailEntity> orderDetails=new ArrayList<>();
	    		for(int i=num;i>0;i--){
	    			OrderDetailEntity detail=new OrderDetailEntity();
	    			int numLen=WinNumber.randomNum(data.getSelectNumber(), 11);
	    			detail.setBettingNum(WinNumber.getBettingNumber(numLen));
	        		detail.setBettingCount(CombinatorialUtil.getCombinatorial(numLen, data.getSelectNumber()));
	        		Double bettingMoney=detail.getBettingCount()*data.getSinglePrice();
	        		int rate=WinNumber.randomNum(1, 10);
	        		bettingMoney=bettingMoney*rate;
	        		detail.setRate(rate);
	        		detail.setBettingMoney(bettingMoney);
	        		detail.setCreateDate(new Date());
	        		totalBettingMoney+=bettingMoney;
	        		orderDetails.add(detail);
	    		}
	    		order.setTotalBettingMoney(totalBettingMoney);
	    		orderService.batchAddOrder(order, orderDetails);
	    	}
    	}
    }
	
}
