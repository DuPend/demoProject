package com.xinghuo.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiuJian
 * @Date: 2019/11/27 0027 19:17
 * @Version: V1.0
 */

public class TbStatus implements Serializable {
    private Integer statusId;
    private  Integer patentId;
    private  String statusContent;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPatentId() {
        return patentId;
    }

    public void setPatentId(Integer patentId) {
        this.patentId = patentId;
    }

    public String getStatusContent() {
        return statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }
}
