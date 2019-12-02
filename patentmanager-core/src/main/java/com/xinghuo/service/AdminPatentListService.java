package com.xinghuo.service;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbPatent;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description   管理员根据条件查询相关专利信息（包含认领和未认领）
 * @date 2019/11/22 10:08
 */



public interface AdminPatentListService {


        /*管理员多条件查询专利  未认领专利在前面显示*/
    Page<TbPatent> selectByPatentInfo(TbPatent patent, int page, int rows);

    /*根据专利id 查询专利详情*/
    List<TbPatent> selectByPatentId(Integer id);

     /*查询所有专利信息*/
    Page<TbPatent> selectAll(int page, int rows);
}
