package com.xinghuo.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 部门实体类
 * @author dupeng
 * @date 2019-11-17 11:44:52
 * @version V1.0
 */
@AllArgsConstructor
@NoArgsConstructor

public class TbDept implements Serializable {

    /**
     * 主键
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 上级部门id
     */
    private Long parentId;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
