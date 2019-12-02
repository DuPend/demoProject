package com.xinghuo.service.impl;

import com.xinghuo.mapper.SearchMapper;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchMapper searchMapper;

    @Override
    public List findCondition(TbPatent patent) {
        return searchMapper.findCondition(patent);
    }
}




