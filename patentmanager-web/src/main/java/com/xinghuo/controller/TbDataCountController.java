package com.xinghuo.controller;

import com.xinghuo.pojo.DataCount;
import com.xinghuo.service.TbDataCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据统计控制层
 * @author: 杜鹏
 * @date: 2019-11-22 21:36:24
 * @version: V1.0
 */
@RestController
@RequestMapping("/data")
public class TbDataCountController {
    @Autowired
    private TbDataCountService dataCountService;

    /**
     * @description: 专利数据统计
     * @author: dupeng
     * @param:
     * @return: 专利数据统计数据
     * @date: 2019-11-22 22:33
     */
    @RequestMapping("/findDataCount")
    public DataCount findDataCount() {
        return dataCountService.findDataCount();
    }

    /**
     * @description: 按照年统计公司专利数据(以折线图的形式显示)
     * @author:
     * @param:
     * @return:
     * @date: 2019-11-24 18:38
     */
    @RequestMapping("/yearCount")
    public List<Map<String, List<Object>>> yearCount() {
        List<HashMap<String, Object>> maps = dataCountService.yearCount();
        List<Map<String, List<Object>>> map = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        Map<String,List<Object>> patentList1 = new HashMap<>();
        Map<String,List<Object>> patentList2 = new HashMap<>();
        patentList2.put("年份",list1);
        patentList1.put("专利数量",list2);
        map.add(patentList1);
        map.add(patentList2);
        int i = 1;
        for (HashMap<String, Object> hashMap : maps) {
            for (Map.Entry<String, Object> m : hashMap.entrySet()) {
                if(i%2==0){
                    list1.add(m.getValue());
                }else{
                    list2.add(m.getValue());
                }
                i++;
            }
        }
        return map;
    }

    /**
     * @description: 按照部门统计公司专利数据(以柱状图的形式显示)
     * @author: dupeng
     * @param:
     * @return:
     * @date: 2019-11-24 18:42
     */
    @RequestMapping("/deptCount")
    public List<Map<String, Object>> deptCount() {
        return dataCountService.deptCount();
    }



}
