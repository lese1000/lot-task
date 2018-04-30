package com.tp.lottery.service.entity;

import java.util.Date;

public class JoinBuy {
    private Long id;

    private Long orderId;

    private Double singlePieceMoney;

    private Integer totalPieceNum;

    private Integer remainingPieceNum;

    private Byte planType;

    private Integer leastNum;

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

    public Double getSinglePieceMoney() {
        return singlePieceMoney;
    }

    public void setSinglePieceMoney(Double singlePieceMoney) {
        this.singlePieceMoney = singlePieceMoney;
    }

    public Integer getTotalPieceNum() {
        return totalPieceNum;
    }

    public void setTotalPieceNum(Integer totalPieceNum) {
        this.totalPieceNum = totalPieceNum;
    }

    public Integer getRemainingPieceNum() {
        return remainingPieceNum;
    }

    public void setRemainingPieceNum(Integer remainingPieceNum) {
        this.remainingPieceNum = remainingPieceNum;
    }

    public Byte getPlanType() {
        return planType;
    }

    public void setPlanType(Byte planType) {
        this.planType = planType;
    }

    public Integer getLeastNum() {
        return leastNum;
    }

    public void setLeastNum(Integer leastNum) {
        this.leastNum = leastNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}