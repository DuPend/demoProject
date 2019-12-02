package com.xinghuo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TbFlow {
    /**流程id**/
    private Integer flowId;
    /**修改下**/
    private String editSelectioin;
    /**修改人**/
    private String editUser;
    /**时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date flowDate;
    /**专利id**/
    private Integer patentId;
    /**专利实体类**/
    private TbPatent tbPatent;

    public TbPatent getTbPatent() {
        return tbPatent;
    }

    public void setTbPatent(TbPatent tbPatent) {
        this.tbPatent = tbPatent;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getEditSelectioin() {
        return editSelectioin;
    }

    public void setEditSelectioin(String editSelectioin) {
        this.editSelectioin = editSelectioin;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(Date flowDate) {
        this.flowDate = flowDate;
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }
}
