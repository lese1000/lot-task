package com.tp.lottery.service.mapper;

import org.apache.ibatis.annotations.Param;

import com.tp.lottery.service.entity.PBalance;
import com.tp.lottery.service.entity.PBalanceRecord;

public interface BalanceMapper {
	int addBalance(PBalance entity);
	int addBalanceRecord(PBalanceRecord entity);
	int updateBalance(PBalance entity);
	PBalance findDataByPlayId(@Param("playerId")Long playerId);
}
