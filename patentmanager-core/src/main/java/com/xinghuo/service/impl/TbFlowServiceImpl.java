package com.xinghuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinghuo.mapper.TbFlowMapper;
import com.xinghuo.pojo.TbFlow;
import com.xinghuo.service.TbFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 姜爽
 * @date: 2019/11/22 8:36
 * @version: V1.0
 */
@Service
public class TbFlowServiceImpl implements TbFlowService {
    //注入mapper层

    @Autowired
    private TbFlowMapper tbFlowMapper;
    @Override
    public int addTbFlowService(TbFlow tbFlow) {
        return tbFlowMapper.addTbFlow(tbFlow);
    }

    @Override
    public Page<TbFlow> showTbFlowService(int page, int rows) {
        //用插件进行分页
        List<TbFlow> list = tbFlowMapper.showTbFlowAdmin();
        if (null == list || list.size() == 0) {
            return null;
        }
        PageHelper.startPage(page, rows);
        return tbFlowMapper.showTbFlowAdmin();
    }

    @Override
    public Page<TbFlow> showTbFlowByIdService(Integer patentId, int page, int rows,Integer flag) {
        //用插件进行分页
        List<TbFlow> list = tbFlowMapper.showTbFlowById(patentId,flag);
        if (null == list || list.size() == 0) {
            return null;
        }
        PageHelper.startPage(page, rows);
        return tbFlowMapper.showTbFlowById(patentId,flag);
    }
}