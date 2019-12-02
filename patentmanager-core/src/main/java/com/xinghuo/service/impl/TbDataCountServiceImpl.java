package com.xinghuo.service.impl;

import com.xinghuo.mapper.TbDataCountMapper;
import com.xinghuo.pojo.DataCount;
import com.xinghuo.service.TbDataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据统计服务实现层
 * @author: 杜鹏
 * @date: 2019-11-22 21:33:14
 * @version: V1.0
 */
@Service
public class TbDataCountServiceImpl implements TbDataCountService {
    @Autowired
    private TbDataCountMapper dataCountMapper;

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:34
     */
    @Override
    public DataCount findDataCount() {

        return dataCountMapper.findDataCount();
    }

    /**
     * @description: 按照年统计公司专利数据
     * @author: dupeng
     * @param:
     * @return:
     * @date: 2019-11-24 18:38
     */
    @Override
    public List<HashMap<String, Object>> yearCount() {

        return dataCountMapper.yearCount();
    }

    /**
     * @description: 按照部门统计公司专利数据(以柱状图的形式显示)
     * @author: dupeng
     * @param:
     * @return:
     * @date: 2019-11-24 18:42
     */
    @Override
    public List<Map<String, Object>> deptCount() {
        return dataCountMapper.deptCount();
    }
}
