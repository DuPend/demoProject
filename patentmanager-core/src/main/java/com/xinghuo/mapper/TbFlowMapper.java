package com.xinghuo.mapper;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbFlow;
import org.apache.ibatis.annotations.Mapper;
/**
 * @ Author：姜爽
 * @ Description：
 */
@Mapper
public interface TbFlowMapper {

    /**
     * @Description  增加操作日志
     * @return int
     */
    int addTbFlow(TbFlow tbFlow);
    /**
     * @Description  查询所有的操作日志管理员
     * @return com.github.pagehelper.Page<com.xinghuo.pojo.TbFlow>
     */
    Page<TbFlow> showTbFlowAdmin();
    /**
     * @Description  根据专利ID查询操作日志
     * @return com.github.pagehelper.Page<com.xinghuo.pojo.TbFlow>
     */
    Page<TbFlow> showTbFlowById(Integer patentId,Integer flag);
}