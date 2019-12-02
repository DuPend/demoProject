package com.xinghuo.service;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbIndicatorExcend;


public interface TbIndicatorService {

    /**
     * 管理员专利指标查询
     * @return
     */
    Page<TbIndicatorExcend> findAll(int page, int rows);

    /**
     * 管理员专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    Page<TbIndicatorExcend> findTerm(TbIndicatorExcend tbIndicatorExcend, int page, int rows);

    /**
     * 用户专利指标查询
     * @return
     */
    Page<TbIndicatorExcend> findUserAll(int page, int rows);

    /**
     * 用户专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    Page<TbIndicatorExcend> findUserTerm(TbIndicatorExcend tbIndicatorExcend, Integer page,
                                         Integer rows);


    /**
     * 添加指标
     * @param tbIndicator
     */
    void addIndicator(TbIndicator tbIndicator);
}
