package com.tp.lottery.service.entity;

import java.util.Date;

public class OrderDetail {
    private Long id;

    private Long orderId;

    private String bettingNum;

    private Integer bettingCount;

    private Double bettingMoney;

    private Integer rate;

    private Double winPrize;

    private Date createDate;

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
        this.bettingNum = bettingNum == null ? null : bettingNum.trim();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}