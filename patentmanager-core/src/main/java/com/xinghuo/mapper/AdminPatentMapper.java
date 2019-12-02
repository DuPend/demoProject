package com.xinghuo.mapper;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by   Lenovo on 2019/11/25
 **/
@Mapper
@Repository
public interface AdminPatentMapper {

    List<TbPatent> adminDetail(Integer id);

    /*管理员查询所有的专利*/
    Page<TbPatent> selectAll();

    /*根据相关专利信息查询所有专利包含认领和未被认领（管理员） zhou_gc*/
    Page<TbPatent>  getPatentList(TbPatent tbPatent);

    /*根据专利id查询相关专利信息  zhou_gc*/
    TbPatent  getPatentByPatentId(Integer patent_id);


}
