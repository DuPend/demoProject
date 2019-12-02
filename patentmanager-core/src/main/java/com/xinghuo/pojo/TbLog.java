package com.xinghuo.pojo;

public class TbLog {
    /**日志id**/
    private Integer logId;
    /**日志名称**/
    private String logName;
    /**日志地址**/
    private String logAddress;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName == null ? null : logName.trim();
    }

    public String getLogAddress() {
        return logAddress;
    }

    public void setLogAddress(String logAddress) {
        this.logAddress = logAddress == null ? null : logAddress.trim();
    }
}