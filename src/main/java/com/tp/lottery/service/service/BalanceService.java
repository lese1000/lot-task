package com.tp.lottery.service.service;

import com.tp.lottery.service.entity.PBalance;


public interface BalanceService{

	PBalance findDataByPlayId(long playId);
	
	boolean savaBalanceForwin(long orderId,long playId,Double winprize);
	
	boolean savaBalanceForJoinBuyFailed(long orderId,long playId,Double returnMoney);
	

}
