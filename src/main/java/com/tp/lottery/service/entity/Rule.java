package com.tp.lottery.service.entity;

import java.util.Date;

public class Rule {
    private Long id;

    private String ruleName;

    private Byte isDefault;

    private Double winPrize;

    private Byte status;

    private String remark;

    private Date createDate;

    private Byte playType;

    private Byte selectNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Double getWinPrize() {
        return winPrize;
    }

    public void setWinPrize(Double winPrize) {
        this.winPrize = winPrize;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Byte getPlayType() {
        return playType;
    }

    public void setPlayType(Byte playType) {
        this.playType = playType;
    }

    public Byte getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(Byte selectNumber) {
        this.selectNumber = selectNumber;
    }
}