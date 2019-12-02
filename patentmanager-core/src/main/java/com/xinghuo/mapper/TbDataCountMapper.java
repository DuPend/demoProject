package com.xinghuo.mapper;

import com.xinghuo.pojo.DataCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-22 21:34
 * @version: V1.0
 */
@Mapper
@Repository
public interface TbDataCountMapper {

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:34
     */
    DataCount findDataCount();


    /**
     * @description: 按照年统计公司专利数据(以柱状图的形式显示)
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
