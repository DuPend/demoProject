package com.xinghuo.service;

import com.xinghuo.pojo.DataCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据统计服务接口层
 * @author: 杜鹏
 * @date: 2019-11-22 21:36:21
 * @version: V1.0
 */
public interface TbDataCountService {

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:33
     */
    DataCount findDataCount();

    /**
     * @description: 按照年统计公司专利数据
     * @author: dupeng
     * @param:
     * @return:
     * @date: 2019-11-24 18:38
     */
    List<HashMap<String, Object>> yearCount();

    /**
     * @description: 按照部门统计公司专利数据(以柱状图的形式显示)
     * @author: dupeng
     * @param:
     * @return:
     * @date: 2019-11-24 18:42
     */
    List<Map<String, Object>> deptCount();
}
