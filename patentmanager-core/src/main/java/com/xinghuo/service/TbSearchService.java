package com.xinghuo.service;

import com.xinghuo.pojo.TbPatent;

import java.util.List;
/**
 *@Author:duanlian
 *@param:
 *@return:
 *@description:
 */
public interface TbSearchService {

    List findCondition(TbPatent patent);

}
