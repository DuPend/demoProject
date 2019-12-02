package com.xinghuo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: LiuJian
 * @Time: 2019/11/21 0021 17:08
 */
@Mapper
public interface TbPlanMapper {
    //根据进度内容查询进度id
    Integer findPlanByContent(String planContent);

    //将通过与否的状态添加到状态表
    Integer insertStatus(@Param("patentId") Integer patentId, @Param("statusContent") String statusContent);

    //根据专利id修改状态表对应专利的状态
    Integer updateStatus(@Param("patentId") Integer patentId, @Param("statusContent") String statusContent);

}
