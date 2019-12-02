package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.PageInfo;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.AdminPatentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description  管理员====》专利列表页面显示，及专利详细信息展示，包含认领专利和未被认领专利，其中未被认领专利在前
 * @date 2019/11/22 9:48
 */



@Controller
@RequestMapping("/adminpatentlist")
public class AdminPatentListController {

    @Autowired
    private AdminPatentListService adminPatentListService;
    /**
     *@描述 管理员根据用户查询条件（非指标类型）查询符合条件专利
     *@参数  前端传入查询条件
     *@返回值  专利集合
     *@创建人  zhou_gc@suixingpay.com
     *@创建时间  2019/11/22
     *@修改人和其它信息
     */
    @GetMapping("/selectByPatentInfo")
    @ResponseBody
    public PageInfo<TbPatent> selectByPatentInfo(TbPatent patent,
                                                 @RequestParam(defaultValue = "1", value = "currentPage")int page,
                                                 @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> patentList = adminPatentListService.selectByPatentInfo(patent, page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(patentList);
        return  pageInfo;
    }

    /**
     *@描述  根据专利id查询某个专利的具体信息
     *@参数  输入参数为专利id
     *@返回值  某个专利具体信息
     *@创建人  zhou_gc@suixingpay.com
     *@创建时间  2019/11/22
     *@修改人和其它信息
     */
    @RequestMapping("/selectByPatentId")
    @ResponseBody
    public List<TbPatent>  selectByPatentId(Integer  id) {
        List<TbPatent> list = adminPatentListService.selectByPatentId(id);
        return list;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public PageInfo<TbPatent> selectAll(
            @RequestParam(defaultValue = "1", value = "currentPage")int page,
            @RequestParam(defaultValue = "10", value = "pageSize")int rows) {

        Page<TbPatent> list = adminPatentListService.selectAll(page, rows);
        PageInfo<TbPatent> pageInfo = new PageInfo<>(list);
        return  pageInfo;

    }


}
