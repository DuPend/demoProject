package com.xinghuo.service.impl;

import com.xinghuo.mapper.TbPlanMapper;
import com.xinghuo.service.TbPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: LiuJian
 * @Date: 2019/11/22 0022 15:11
 * @Version: V1.0
 */

@Service
public class TbPlanServiceImpl implements TbPlanService {
    @Resource
    private TbPlanMapper tbPlanMapper;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    //根据进度内容查询进度id
    /*@Override public Integer findPlanByContent(String planContent) {
        Integer planId = (Integer)redisTemplate.boundHashOps("plan").get(planContent);
        if(planId==null){
            planId = tbPlanMapper.findPlanByContent(planContent);
            redisTemplate.boundHashOps("plan").put(planContent,planId);
        }
        return planId;
    }*/

    @Override public Integer findPlanByContent(String planContent) {

        return tbPlanMapper.findPlanByContent(planContent);
    }

    @Override public Integer insertStatus(Integer patentId, String statusContent) {
        return tbPlanMapper.insertStatus(patentId, statusContent);
    }

    @Override public Integer updateStatus(Integer patentId, String statusContent) {
        return tbPlanMapper.updateStatus(patentId, statusContent);
    }
}
