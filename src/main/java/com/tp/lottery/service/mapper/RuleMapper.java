package com.tp.lottery.service.mapper;

import java.util.List;

import com.tp.lottery.service.vo.AutoBettingVO;

public interface RuleMapper {
	List<AutoBettingVO> findAutoBetting();
}
