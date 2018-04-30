package com.tp.lottery.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.mapper.LotteryNumMapper;
import com.tp.lottery.service.mapper.RuleMapper;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.service.vo.AutoBettingVO;

@Service
public class LotteryNumServiceImpl implements LotteryNumService {


	@Autowired
	private LotteryNumMapper lotteryNumMapper;
	@Autowired
	private RuleMapper ruleMapper;
	
	@Override
	public int batchInsert(List<LotteryNumEntity> lotteryNums) {
		return lotteryNumMapper.batchInsert(lotteryNums);
	}

	@Override
	public LotteryNumEntity findLastLottery() {
		return lotteryNumMapper.findLastLottery();
	}

	@Override
	public List<AutoBettingVO> findAutoBetting() {
		return ruleMapper.findAutoBetting();
	}

	@Override
	public LotteryNumEntity findLotteryByOpenTime() {
		return lotteryNumMapper.findLotteryByOpenTime();
	}

	@Override
	public List<LotteryNumEntity> listLotteryByOpenTime() {
		// TODO Auto-generated method stub
		return lotteryNumMapper.listLotteryByOpenTime();
	}

	@Override
	public Long countTodayLotteryNum() {
		// TODO Auto-generated method stub
		return lotteryNumMapper.countTodayLotteryNum();
	}

}
