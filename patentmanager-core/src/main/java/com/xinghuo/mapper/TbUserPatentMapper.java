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
 *@description:查询用户所有专利、查询用户专利详情、认领状态改变
 */
@Mapper
@Repository
public interface TbUserPatentMapper {

    Page<TbPatent> findAll();
    List<TbPatent> findDetail(Integer patentId);
    int update(TbPatent tbPatent);

}
