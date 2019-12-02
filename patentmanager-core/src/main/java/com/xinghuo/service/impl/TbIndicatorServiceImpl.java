package com.xinghuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinghuo.mapper.TbIndicatorMapper;
import com.xinghuo.pojo.TbIndicator;
import com.xinghuo.pojo.TbIndicatorExcend;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.TbIndicatorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: TODO
 * @author: 杜鹏
 * @date: 2019-11-21 17:41
 * @version: V1.0
 */
@Service
public class TbIndicatorServiceImpl implements TbIndicatorService {

    @Resource
    private TbIndicatorMapper tbIndicatorMapper;

    /**
     * 管理员指标查询
     * @return
     */
    @Override
    public Page<TbIndicatorExcend> findAll(int pageNum, int pageSize) {
        //查看专利是否为空
        //return tbPatentMapper.findPatent();

        List<TbPatent> list = tbIndicatorMapper.findPatent();
        if (null == list || list.size() == 0) {
            return null;
        }
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return tbIndicatorMapper.findAll();
    }

    /**
     * 管理员专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    @Override
    public Page<TbIndicatorExcend> findTerm(TbIndicatorExcend tbIndicatorExcend, int pageNum, int pageSize) {
        /*CheckObjectIsNullUtils checkObjectIsNullUtils = new CheckObjectIsNullUtils();
        boolean result = checkObjectIsNullUtils.objCheckIsNull(tbIndicatorExcend);
        if(result==false){
            return null;
        }*/
        PageHelper.startPage(pageNum, pageSize);
        return tbIndicatorMapper.findTerm(tbIndicatorExcend);
    }


    /**
     * 用户指标查询
     * @return
     */
    @Override
    public Page<TbIndicatorExcend> findUserAll(int pageNum, int pageSize) {
        //查看专利是否为空
        //return tbPatentMapper.findPatent();

        List<TbPatent> list = tbIndicatorMapper.findPatent();
        if (null == list || list.size() == 0) {
            return null;
        }
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return tbIndicatorMapper.findUserAll();
    }

    /**
     * 用户专利指标条件查询
     * @param tbIndicatorExcend 指标查询条件
     * @return
     */
    @Override
    public Page<TbIndicatorExcend> findUserTerm(TbIndicatorExcend tbIndicatorExcend, Integer pageNum, Integer pageSize) {
        /*CheckObjectIsNullUtils checkObjectIsNullUtils = new CheckObjectIsNullUtils();
        boolean result = checkObjectIsNullUtils.objCheckIsNull(tbIndicatorExcend);
        if(result==false){
            return null;
        }*/
        PageHelper.startPage(pageNum, pageSize);
        return tbIndicatorMapper.findUserTerm(tbIndicatorExcend);
    }

    //添加指标
    @Override public void addIndicator(TbIndicator tbIndicator) {
        tbIndicatorMapper.addIndicator(tbIndicator);
    }

    //    专利模块  刘健（将来引入）
    /*@Autowired
    private TbPatentMapper tbPatentMapper;*/
}
