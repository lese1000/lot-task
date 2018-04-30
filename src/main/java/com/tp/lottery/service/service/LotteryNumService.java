package com.tp.lottery.service.service;

import java.util.List;

import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.vo.AutoBettingVO;


public interface LotteryNumService{

	int batchInsert(List<LotteryNumEntity> lotteryNums);
	LotteryNumEntity findLastLottery();
	List<AutoBettingVO> findAutoBetting();
	LotteryNumEntity findLotteryByOpenTime();
	
	List<LotteryNumEntity>listLotteryByOpenTime();
	
	Long countTodayLotteryNum();


}
