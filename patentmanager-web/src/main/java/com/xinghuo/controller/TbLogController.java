package com.xinghuo.controller;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.PageInfo;
import com.xinghuo.pojo.TbLog;
import com.xinghuo.service.TbLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:41
 * @version: V1.0
 */
@Controller
@RequestMapping("/log")
public class TbLogController {

    @Autowired
    private TbLogService tbLogService;

    @RequestMapping("/showLog")
    @ResponseBody
    public PageInfo<TbLog> showAllLog(@RequestParam(defaultValue = "1", value = "currentPage")int page,
                                      @RequestParam(defaultValue = "10", value = "pageSize")int rows) {
        Page<TbLog> TbLogList = tbLogService.selectAllLogService(page, rows);
        PageInfo<TbLog> pageInfo = new PageInfo<>(TbLogList);
        return pageInfo;
    }
}
