package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.PageInfo;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 姜爽
 * @date: 2019/12/4 15:59
 * @description: 管理员登陆显示待审核的所有专利
 * @version: V1.0
 */
@RequestMapping("/adminPatent")
@Controller
public class AdminPatentShowController {
    @Autowired
    private UserPatentService userPatentService;

    @RequestMapping("/showStatusOne")
    @ResponseBody
    public PageInfo<TbPatent> showStatusOneController(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                                  @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> tbPatents = userPatentService.showPatentByStatus(1,page,rows);
        PageInfo<TbPatent> tbPatentsInfoOne = new PageInfo<>(tbPatents);
        return  tbPatentsInfoOne;
    }

    @RequestMapping("/showStatusFive")
    @ResponseBody
    public PageInfo<TbPatent> showStatusFiveController(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                                      @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> tbPatents = userPatentService.showPatentByStatus(5,page,rows);
        PageInfo<TbPatent> tbPatentsInfoFive = new PageInfo<>(tbPatents);
        return  tbPatentsInfoFive;
    }

    @RequestMapping("/showStatusSix")
    @ResponseBody
    public PageInfo<TbPatent> showStatusSixController(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                                      @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbPatent> tbPatents = userPatentService.showPatentByStatus(6,page,rows);
        PageInfo<TbPatent> tbPatentsInfoSix = new PageInfo<>(tbPatents);
        return  tbPatentsInfoSix;
    }
}
