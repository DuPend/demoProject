package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.PageInfo;
import com.xinghuo.pojo.TbFlow;
import com.xinghuo.service.TbFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:41
 * @version: V1.0
 */
@RestController
public class TbFlowController {
    //注入TbFlowService层
    @Autowired
    private TbFlowService tbFlowService;
    //查询所有的操作日志
    @RequestMapping("/showTbFlow")
    PageInfo<TbFlow> showTbFlowController(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                          @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbFlow> tbFlows = tbFlowService.showTbFlowService(page, rows);
        PageInfo<TbFlow> pageInfo = new PageInfo<>(tbFlows);
        return  pageInfo;
    }
    //普通用户根据专利ID查询操作日志
    @RequestMapping("/showTbFlowByIdUser")
    PageInfo<TbFlow> showTbFlowByIdUserController(HttpServletRequest httpServletRequest,
                                              @RequestParam(defaultValue = "1", value = "currentPage")int page,
                                              @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbFlow> tbFlows = tbFlowService.showTbFlowByIdService(
                Integer.valueOf((String) httpServletRequest.getParameter("patentId")), page, rows);
        PageInfo<TbFlow> pageInfo = new PageInfo<>(tbFlows);
        return pageInfo;
    }
    //管理员根据专利ID查询操作日志
    @RequestMapping("/showTbFlowByIdAdmin")
    PageInfo<TbFlow> showTbFlowByIdAdminController(HttpServletRequest httpServletRequest,
                                              @RequestParam(defaultValue = "1", value = "currentPage")int page,
                                              @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbFlow> tbFlows = tbFlowService.showTbFlowByIdAdminService(
                Integer.valueOf((String) httpServletRequest.getParameter("patentId")), page, rows);
        PageInfo<TbFlow> pageInfo = new PageInfo<>(tbFlows);
        return pageInfo;
    }
}