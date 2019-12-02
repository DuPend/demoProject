package com.xinghuo.mapper;
import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbIndicatorExcend;
import com.xinghuo.pojo.TbPatent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbIndicatorMapper {
    int deleteByPrimaryKey(Integer indId);

    int insert(TbIndicator record);

    int insertSelective(TbIndicator record);

    TbIndicator selectByPrimaryKey(Integer indId);

    int updateByPrimaryKeySelective(TbIndicator record);

    int updateByPrimaryKey(TbIndicator record);

    /**
     * 管理员指标查询
     * @return
     */
    Page<TbIndicatorExcend> findAll();


    //添加指标
    void addIndicator(TbIndicator tbIndicator);


//    专利模块  刘健(将来删除，直接调用刘健模块)
    /**
     * 查询全部专利
     * @return
     */
    List<TbPatent> findPatent();

    /**
     * 管理员专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    Page<TbIndicatorExcend> findTerm(TbIndicatorExcend tbIndicatorExcend);

    /**
     * 用户指标查询
     * @return
     */
    Page<TbIndicatorExcend> findUserAll();

    /**
     * 用户专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    Page<TbIndicatorExcend> findUserTerm(TbIndicatorExcend tbIndicatorExcend);
}