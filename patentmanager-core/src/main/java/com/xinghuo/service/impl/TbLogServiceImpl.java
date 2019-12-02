package com.xinghuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinghuo.mapper.TbLogMapper;
import com.xinghuo.pojo.TbLog;
import com.xinghuo.service.TbLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbLogServiceImpl implements TbLogService {

    @Autowired
    private TbLogMapper tbLogMapper;
    @Override
    public int addLogService(TbLog tbLog) {
        return tbLogMapper.addLog(tbLog);
    }

    @Override
    public TbLog selectLogByNameService(String name) {
        return tbLogMapper.selectLogByName(name);
    }

    @Override
    public Page<TbLog> selectAllLogService(int pageNum, int pageSize) {
        //用插件进行分页
        List<TbLog> list = tbLogMapper.selectAllLog();
        if (null == list || list.size() == 0) {
            return null;
        }
        PageHelper.startPage(pageNum, pageSize);
        return tbLogMapper.selectAllLog();
    }
}
