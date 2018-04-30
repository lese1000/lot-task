package com.tp.lottery.service.entity;

import java.util.Date;

public class Order {
    private Long id;

    private String orderNum;

    private Long lotteryNumId;

    private Long playerId;

    private Byte isJoinBuy;

    private Byte orderStatus;

    private Date createTime;

    private Double totalWinMoney;

    private Double totalBettingMoney;

    private Long ruleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
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

    public Byte getIsJoinBuy() {
        return isJoinBuy;
    }

    public void setIsJoinBuy(Byte isJoinBuy) {
        this.isJoinBuy = isJoinBuy;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
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

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
}