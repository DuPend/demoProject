package com.xinghuo.mapper;

import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Author:段炼 on 2019/11/23 11:45
 *@param: patent
 *@return:
 *@description:
 */
@Mapper
@Repository
public interface SearchMapper {

    List<TbPatent> findCondition(TbPatent patent);



}
