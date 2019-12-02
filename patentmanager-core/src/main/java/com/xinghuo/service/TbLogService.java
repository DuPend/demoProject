package com.xinghuo.service;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbLog;

public interface TbLogService {
    /*
    增加日志
     */
    int addLogService(TbLog tbLog);
    /*
    根据名称查询
     */

    TbLog selectLogByNameService(String name);
    /*
     查询所有的日志文件
     */

    Page<TbLog> selectAllLogService(int page, int rows);
}