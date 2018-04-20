/**
 * apple
 */
package com.tp.lottery.service.entity;

import java.util.Date;

/**
 * 余额记录Entity
 * @author asd
 * @version 2018-01-29
 */
public class PBalanceRecord  {
	
	private Long id;		// id
	private Integer balanceType;		// 余额操作类型：1，充值，2，提现，3，消费，4，中奖，5.活动奖励,6，积分兑换
	private Long orderId;		// order_id
	private Long playerId;		// player_id
	private Double balanceVal;		// balance_val
	private String playerName;		// 客户姓名
	private String createUser;
	private Date createDate;
	
	
	
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
	public Integer getBalanceType() {
		return balanceType;
	}
	public void setBalanceType(Integer balanceType) {
		this.balanceType = balanceType;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
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
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
	
	
	
	
	

	
}