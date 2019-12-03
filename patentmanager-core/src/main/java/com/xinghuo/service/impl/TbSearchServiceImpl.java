package com.xinghuo.service.impl;

import com.xinghuo.mapper.TbSearchMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbSearchServiceImpl implements TbSearchService {
    @Autowired
    private TbSearchMapper tbSearchMapper;

    @Override
    public List findCondition(TbPatent patent) {
        return tbSearchMapper.findCondition(patent);
    }
}




