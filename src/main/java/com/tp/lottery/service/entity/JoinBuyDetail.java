package com.tp.lottery.service.entity;

import java.util.Date;

public class JoinBuyDetail {
    private Long id;

    private Long joinBuyId;

    private Long playerId;

    private Integer buyCount;

    private Double buyMoney;

    private Double winPrize;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJoinBuyId() {
        return joinBuyId;
    }

    public void setJoinBuyId(Long joinBuyId) {
        this.joinBuyId = joinBuyId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Double getWinPrize() {
        return winPrize;
    }

    public void setWinPrize(Double winPrize) {
        this.winPrize = winPrize;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}