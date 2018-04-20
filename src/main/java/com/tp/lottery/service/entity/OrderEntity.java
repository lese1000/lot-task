package com.tp.lottery.service.entity;

import java.util.Date;

public class OrderEntity {
	private Long id;
	private Long lotteryNumId;
	private Long playerId;
	private Long ruleId;
	private Integer isJoinBuy;
	private Integer orderStatus;
	private String orderNum;
	private Date createTime;
	private Double totalWinMoney;
	private Double totalBettingMoney;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLotteryNumId() {
		return lotteryNumId;
	}
	public void setLotteryNumId(Long lotteryNumId) {
		this.lotteryNumId = lotteryNumId;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getIsJoinBuy() {
		return isJoinBuy;
	}
	public void setIsJoinBuy(Integer isJoinBuy) {
		this.isJoinBuy = isJoinBuy;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getTotalWinMoney() {
		return totalWinMoney;
	}
	public void setTotalWinMoney(Double totalWinMoney) {
		this.totalWinMoney = totalWinMoney;
	}
	public Double getTotalBettingMoney() {
		return totalBettingMoney;
	}
	public void setTotalBettingMoney(Double totalBettingMoney) {
		this.totalBettingMoney = totalBettingMoney;
	}
	
	
	
	
}
