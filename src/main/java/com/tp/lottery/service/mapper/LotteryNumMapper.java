package com.tp.lottery.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tp.lottery.service.entity.LotteryNumEntity;

public interface LotteryNumMapper {
	int batchInsert(@Param("lotteryNums")List<LotteryNumEntity> lotteryNums);
	
	LotteryNumEntity findLastLottery();
	LotteryNumEntity findLotteryByOpenTime();
}
