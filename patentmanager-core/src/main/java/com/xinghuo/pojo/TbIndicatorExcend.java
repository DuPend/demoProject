package com.xinghuo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @description: 指标扩展类
 * @author: 杜鹏
 * @date: 2019-11-21 18:47
 * @version: V1.0
 */


public class TbIndicatorExcend extends TbIndicator {
    /**
     * 专利类
     */
    //private TbPatent tbPatent;
    /**
     * 专利名称
      */
    private String patentName;

    /**
     * 专利进度
     */
    private String planContent;

    /**
     * 申请日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proposeDate;

    /**
     * 发明人中文名称
     */
    private String proposerName;

    /**
     * 撰写人
     */
    private String userName;

    /**
     * 申请号
     */
    private String proposeNumber;

    /**
     * 进度id
     */
    private Integer planId;

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public Date getProposeDate() {
        return proposeDate;
    }

    public void setProposeDate(Date proposeDate) {
        this.proposeDate = proposeDate;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProposeNumber() {
        return proposeNumber;
    }

    public void setProposeNumber(String proposeNumber) {
        this.proposeNumber = proposeNumber;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
}
