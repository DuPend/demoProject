package com.xinghuo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * create by   段炼 on 2019/11/22
 **/
public class TbDetail {
    /**专利id**/
    private Integer patentId;
    /**专利批次**/
    private String batch;
    /**专利名称**/
    private String patentName;
    /**案件文号**/
    private String caseNumber;
    /**申请号**/
    private String proposeNumber;
    /**申请人中文名称**/
    private String proposerName;
    /**法律状态**/
    private String lawStatus;
    /**专利类型**/
    private String patentType;
    /**发明人中文名称**/
    private String inventorName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    /**申请日**/
    private Date proposeDate;
    /**技术联系人**/
    private String technicalContact;
    /**备注**/
    private String remark;
    /**创建者**/
    private TbUser creator;
    /**进度实体类**/
    private TbPlan tbPlan;
    /**流程实体类**/
    private TbFlow tbFlow;


    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getProposeNumber() {
        return proposeNumber;
    }

    public void setProposeNumber(String proposeNumber) {
        this.proposeNumber = proposeNumber;
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getLawStatus() {
        return lawStatus;
    }

    public void setLawStatus(String lawStatus) {
        this.lawStatus = lawStatus;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName;
    }

    public Date getProposeDate() {
        return proposeDate;
    }

    public void setProposeDate(Date proposeDate) {
        this.proposeDate = proposeDate;
    }

    public String getTechnicalContact() {
        return technicalContact;
    }

    public void setTechnicalContact(String technicalContact) {
        this.technicalContact = technicalContact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public TbUser getCreator() {
        return creator;
    }

    public void setCreator(TbUser creator) {
        this.creator = creator;
    }

    public TbPlan getTbPlan() {
        return tbPlan;
    }

    public void setTbPlan(TbPlan tbPlan) {
        this.tbPlan = tbPlan;
    }

    public TbFlow getTbFlow() {
        return tbFlow;
    }

    public void setTbFlow(TbFlow tbFlow) {
        this.tbFlow = tbFlow;
    }



}
