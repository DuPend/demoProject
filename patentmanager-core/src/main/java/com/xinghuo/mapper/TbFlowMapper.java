package com.xinghuo.mapper;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbFlow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbFlowMapper {
    /**
     * @ Author     ：姜爽
     * @ Description：
     */
// 增加操作日志

    int addTbFlow(TbFlow tbFlow);
//查询所有的操作日志

    Page<TbFlow> showTbFlow();
//根据专利ID查询操作日志

    Page<TbFlow> showTbFlowById(Integer patentId);
}