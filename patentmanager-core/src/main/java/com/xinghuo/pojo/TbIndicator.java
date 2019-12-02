package com.xinghuo.pojo;

public class TbIndicator {
    /**指标**/
    private Integer indId;
    /**指标详情**/
    private String indDetails;
    /**专利id**/
    private Integer patentId;
    /**专利实体类**/
    private TbPatent tbPatent;


    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public String getIndDetails() {
        return indDetails;
    }

    public void setIndDetails(String indDetails) {
        this.indDetails = indDetails == null ? null : indDetails.trim();
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public TbPatent getTbPatent() {
        return tbPatent;
    }

    public void setTbPatent(TbPatent tbPatent) {
        this.tbPatent = tbPatent;
    }

}
