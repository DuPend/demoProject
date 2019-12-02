package com.xinghuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinghuo.mapper.AdminPatentMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.AdminPatentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description
 * @date 2019/11/22 10:15
 */


@Service
public class AdminPatentListServiceImpl implements AdminPatentListService {


    @Autowired
    private AdminPatentMapper adminPatentMapper;

    // 多条件查询
    @Override public Page<TbPatent> selectByPatentInfo(TbPatent patent, int page, int rows) {
        PageHelper.startPage(page, rows);
        return adminPatentMapper.getPatentList(patent);
    }

    //通过id查询某个专利的具体信息
    @Override
    public List<TbPatent> selectByPatentId(Integer id) {
        List<TbPatent> list = adminPatentMapper.adminDetail(id);
        return list;
    }

    //管理员查询所有
    @Override public Page<TbPatent> selectAll(int pageNum, int pageSize) {
        //用插件进行分页
        List<TbPatent> list = adminPatentMapper.selectAll();
        if (null == list || list.size() == 0) {
            return null;
        }
        PageHelper.startPage(pageNum, pageSize);
        return adminPatentMapper.selectAll();
    }
}
