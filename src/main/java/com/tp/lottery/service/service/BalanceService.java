package com.tp.lottery.service.service;

import java.util.List;

import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.entity.PBalance;


public interface BalanceService{

	PBalance findDataByPlayId(long playId);
	
	boolean savaBalanceForwin(long orderId,long playId,Double winprize);
	

}
