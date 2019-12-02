package com.xinghuo.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
/**
 * @Author 姜爽
 * @Date 19:25 2019/12/2
 * @Description  操作日志实体类
 */
public class TbFlow {
    private Integer flowId;

    private String editSelectioin;

    private String editUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date flowDate;

    private Integer patentId;

    private TbPatent tbPatent;

    private Integer flag;

    public TbFlow() {

    }

    public TbFlow(String editSelectioin, String editUser, Date flowDate, Integer patentId,int flag) {
        this.editSelectioin = editSelectioin;
        this.editUser = editUser;
        this.flowDate = flowDate;
        this.patentId = patentId;
    }

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
