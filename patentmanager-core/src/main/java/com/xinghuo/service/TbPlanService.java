package com.xinghuo.service;

/**
 * @Description:
 * @Author: LiuJian
 * @Time: 2019/11/22 0022 15:09
 */
public interface TbPlanService {
    //根据进度内容查询进度id
    Integer findPlanByContent(String planContent);

    //将通过与否的状态添加到状态表
    Integer insertStatus(Integer patentId, String statusContent);

    //根据专利id修改状态表对应专利的状态
    Integer updateStatus(Integer patentId, String statusContent);
}
