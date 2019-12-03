package com.xinghuo.service;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:33
 * @version: V1.0
 */

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbFlow;

public interface TbFlowService {
    // 增加操作日志

    int addTbFlowService(TbFlow tbFlow);
    //查询所有的操作日志

    Page<TbFlow> showTbFlowService(int page, int rows);
    //根据专利ID查询操作日志

    Page<TbFlow> showTbFlowByIdService(Integer patentId, int page, int rows);
    //管理员根据专利ID查询操作日志

    Page<TbFlow> showTbFlowByIdAdminService(Integer patentId, int page, int rows);
}