package com.tp.lottery.service.entity;

import java.util.Date;

public class OrderDetailEntity {
	private Long id;
	private Long orderId;
	private Long playerId;
	private String bettingNum;
	private Integer bettingCount;
	private Double bettingMoney;
	private Date createDate;
	private Integer rate;
	private Integer playType;
	private Integer selectNumber;
	private Double winPrize;
	private Double winPrizePrice;
	
	
	
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
	public Double getWinPrizePrice() {
		return winPrizePrice;
	}
	public void setWinPrizePrice(Double winPrizePrice) {
		this.winPrizePrice = winPrizePrice;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getBettingNum() {
		return bettingNum;
	}
	public void setBettingNum(String bettingNum) {
		this.bettingNum = bettingNum;
	}
	public Integer getBettingCount() {
		return bettingCount;
	}
	public void setBettingCount(Integer bettingCount) {
		this.bettingCount = bettingCount;
	}
	public Double getBettingMoney() {
		return bettingMoney;
	}
	public void setBettingMoney(Double bettingMoney) {
		this.bettingMoney = bettingMoney;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Double getWinPrize() {
		return winPrize;
	}
	public void setWinPrize(Double winPrize) {
		this.winPrize = winPrize;
	}
	
	
	
	
	
	
	
}
