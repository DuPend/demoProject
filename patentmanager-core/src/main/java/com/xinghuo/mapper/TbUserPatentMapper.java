package com.xinghuo.mapper;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Author:段炼 on 2019/11/23 11:45
 *@param:
 *@return:
 *@description:
 */
@Mapper
@Repository
public interface TbUserPatentMapper {
    /** 查询所有未认领专利**/
    Page<TbPatent> findAll();
    /** 查询专利详情**/
    List<TbPatent> findDetail(Integer patentId);
    /**确认专利状态**/
    int state(Integer patentId);
    /**更新专利状态 **/
    int update(TbPatent tbPatent);
    /**
     * @Author 姜爽
     * @Date 15:42 2019/12/4
     * 根据审核状态查询专利
     */
    Page<TbPatent> showPatentByStatus(Integer planId);

}
