package com.tp.lottery.service.entity;

import java.util.Date;

public class PBalance {
	
	private Long id;		// id
	private Long playerId;		// player_id
	private Double balanceVal;		// 余额
	private Date createDate;
	private Date updateDate;
	
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Double getBalanceVal() {
		return balanceVal;
	}
	public void setBalanceVal(Double balanceVal) {
		this.balanceVal = balanceVal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
