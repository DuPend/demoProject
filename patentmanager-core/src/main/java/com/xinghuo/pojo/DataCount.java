package com.xinghuo.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 数据统计表
 * @author: 杜鹏
 * @date: 2019-11-22 22:09
 * @version: V1.0
 */
@AllArgsConstructor
@NoArgsConstructor

public class DataCount implements Serializable {
    /**
     * 专利总数
     */
    private Long patentTotal;

    /**
     * 已成功申请专利总数
     */
    private Long successNumber;

    /**
     * 申请专利失败数量
     */
    private Long falseNumber;

    /**
     * 申请中专利数
     */
    private Long applyNumber;

    public Long getPatentTotal() {
        return patentTotal;
    }

    public void setPatentTotal(Long patentTotal) {
        this.patentTotal = patentTotal;
    }

    public Long getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Long successNumber) {
        this.successNumber = successNumber;
    }

    public Long getFalseNumber() {
        return falseNumber;
    }

    public void setFalseNumber(Long falseNumber) {
        this.falseNumber = falseNumber;
    }

    public Long getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(Long applyNumber) {
        this.applyNumber = applyNumber;
    }
}
