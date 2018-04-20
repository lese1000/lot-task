package com.tp.lottery.service.vo;

public class AutoBettingVO {
	private Long id;
	private Long playId;
	private Long lotteryTypeId;
	private Long ruleId;
	private Double singlePrice;
	private Integer playType;
	private Integer selectNumber;
	
	
	public Integer getPlayType() {
		return playType;
	}
	public void setPlayType(Integer playType) {
		this.playType = playType;
	}
	public Integer getSelectNumber() {
		return selectNumber;
	}
	public void setSelectNumber(Integer selectNumber) {
		this.selectNumber = selectNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlayId() {
		return playId;
	}
	public void setPlayId(Long playId) {
		this.playId = playId;
	}
	public Long getLotteryTypeId() {
		return lotteryTypeId;
	}
	public void setLotteryTypeId(Long lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}
	
	
}
