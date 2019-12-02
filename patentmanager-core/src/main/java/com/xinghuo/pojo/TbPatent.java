package com.xinghuo.pojo;

/**
 * @program: mypatent
 * @description: 专利实体类
 * @author: Yuyue and duanlian
 * @create: 2019-11-20 19:36
 **/

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbPatent {
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
    /**申请日**/
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date proposeDate;
    /**技术联系人**/
    private String technicalContact;

   // private TbPlan tbplan;
    /**备注**/
    private String remark;
    /**指标列表**/
    private List<TbIndicator> tbIndicators;
    /**进度id**/
    private  Integer planId;
    /**指标详情**/
    private String[] indDetails;
    /**创建者**/
    private TbUser creator;
    /**编写者**/
    private TbUser writer;
    /** plan实体类**/
    private TbPlan tbPlan;

    /** 撰写人id **/
    private Integer writerId;
    /** 创建人id **/
    private Integer creatorId;

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public TbUser getWriter() {
        return writer;
    }

    public void setWriter(TbUser writer) {
        this.writer = writer;
    }

    public List<TbIndicator> getTbIndicators() {
        return tbIndicators;
    }

    public void setTbIndicators(List<TbIndicator> tbIndicators) {
        this.tbIndicators = tbIndicators;
    }


    public String[] getIndDetails() {
        return indDetails;
    }

    public void setIndDetails(String[] indDetails) {
        this.indDetails = indDetails;
    }

   /* public TbPlan getTbplan() {
        return tbplan;
    }

    public void setTbplan(TbPlan tbplan) {
        this.tbplan = tbplan;
    }*/

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public TbUser getCreator() {
        return creator;
    }

    public void setCreator(TbUser creator) {
        this.creator = creator;
    }

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

    public TbPlan getTbPlan() {
        return tbPlan;
    }

    public void setTbPlan(TbPlan tbPlan) {
        this.tbPlan = tbPlan;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
