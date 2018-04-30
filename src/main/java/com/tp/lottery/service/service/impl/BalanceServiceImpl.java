package com.tp.lottery.service.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.entity.PBalance;
import com.tp.lottery.service.entity.PBalanceRecord;
import com.tp.lottery.service.mapper.BalanceMapper;
import com.tp.lottery.service.mapper.OrderMapper;
import com.tp.lottery.service.service.BalanceService;
import com.tp.lottery.service.service.OrderService;
import com.tp.lottery.task.SendPrizeTask;

@Service
public class BalanceServiceImpl implements BalanceService{
	private Logger logger = LoggerFactory.getLogger(BalanceServiceImpl.class);

	@Autowired
	private BalanceMapper balanceMapper;

	@Override
	public PBalance findDataByPlayId(long playId) {
		
		return balanceMapper.findDataByPlayId(playId);
	}

	@Transactional
	@Override
	public boolean savaBalanceForwin(long orderId, long playId, Double winprize) {
		int i=0;
		try {
			PBalance pBalance=findDataByPlayId(playId);
			if(pBalance==null){
				pBalance=new PBalance();
				pBalance.setPlayerId(playId);
				pBalance.setBalanceVal(winprize);
				i=balanceMapper.addBalance(pBalance);
			}else{
				pBalance.setBalanceVal(winprize);
				i=balanceMapper.updateBalance(pBalance);
			}
			if(i>0){
				PBalanceRecord pBalanceRecord=new PBalanceRecord();
				pBalanceRecord.setOrderId(orderId);
				pBalanceRecord.setPlayerId(playId);
				pBalanceRecord.setBalanceType(4);
				pBalanceRecord.setBalanceVal(winprize);
				pBalanceRecord.setCreateUser("system");
				i=balanceMapper.addBalanceRecord(pBalanceRecord);
			}
		} catch (Exception e) {
			i=0;
			logger.error("savaBalanceForwin error ",e);
		}
		return i>0;
	}

	@Transactional
	@Override
	public boolean savaBalanceForJoinBuyFailed(long orderId, long playId, Double returnMoney) {
		int i=0;
		try {
			PBalance pBalance=findDataByPlayId(playId);
			if(pBalance==null){
				pBalance=new PBalance();
				pBalance.setPlayerId(playId);
				pBalance.setBalanceVal(returnMoney);
				i=balanceMapper.addBalance(pBalance);
			}else{
				pBalance.setBalanceVal(returnMoney);
				i=balanceMapper.updateBalance(pBalance);
			}
			if(i>0){
				PBalanceRecord pBalanceRecord=new PBalanceRecord();
				pBalanceRecord.setOrderId(orderId);
				pBalanceRecord.setPlayerId(playId);
				pBalanceRecord.setBalanceType(7);
				pBalanceRecord.setBalanceVal(returnMoney);
				pBalanceRecord.setCreateUser("system");
				i=balanceMapper.addBalanceRecord(pBalanceRecord);
			}
		} catch (Exception e) {
			i=0;
			logger.error("savaBalanceForJoinBuyFailed error ",e);
		}
		return i>0;
	}

	
	

	
	

}
