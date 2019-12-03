package com.xinghuo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xinghuo.mapper.TbPatentMapper;
import com.xinghuo.mapper.TbUserPatentMapper;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbPatent;
import com.xinghuo.service.UserPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: mypatent
 * @description: 用户专利service实现类
 * @author: Yuyue
 * @create: 2019-11-20 19:41
 **/
@Service public class UserPatentServiceImpl implements UserPatentService {

    @Autowired
    private TbPatentMapper patentMapper;

    @Autowired
    private TbUserPatentMapper tbUserPatentMapper;

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;

    //段炼
    @Override
    public Page<TbPatent> findAll(int pageNum, int pageSize) {

        //用插件进行分页
        List<TbPatent> list = tbUserPatentMapper.findAll();
        if (null == list || list.size() == 0) {
            return null;
        }
        PageHelper.startPage(pageNum, pageSize);
        return tbUserPatentMapper.findAll();


    }
    //段炼
    @Override
    public List<TbPatent> findDetail(Integer patentId) {

        List<TbPatent> list = tbUserPatentMapper.findDetail(patentId);
        return list;
    }
    //段炼
    @Override
    public int update(TbPatent tbPatent) {
        return tbUserPatentMapper.update(tbPatent);
    }

    /**
     * @Author:Yuyue
     * @Description:获取用户专利列表
     * @Date:18:04 2019/11/22
     * @Param:
     * @Return:
     */
    @Override public Page<TbPatent> getPatentByUser(Integer userId, int page, int rows) {

        PageHelper.startPage(page, rows);
        return patentMapper.getPatentByUser(userId);
    }

    /**
     * @Author:Yuyue
     * @Description:获取专利详情，通过专利id
     * @Date:18:05 2019/11/22
     * @Param:
     * @Return:
     */
    @Override public TbPatent getPatentById(Integer patentId) {
        return patentMapper.getPatentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:更新专利信息
     * @Date:18:05 2019/11/22
     * @Param:
     * @Return:
     */
    @Override public void updatePatentById(TbPatent tbPatent) {
        //修改专利的基本信息
        patentMapper.updatePatentById(tbPatent);
        if (tbPatent.getTbIndicators() != null) {
            //删除专利对应的指标
            System.out.println("删除啦" + tbPatent.getTbIndicators());
            patentMapper.deleteIndicatorsByPatentId(tbPatent.getPatentId());
            //添加修改的所有指标
            for (int i = 0; i < tbPatent.getTbIndicators().size(); i++) {
                System.out.println(tbPatent.getTbIndicators().get(i).getIndDetails() + "--" + tbPatent.getPatentId());
                patentMapper.insertIndicatorsByPatentId(tbPatent.getTbIndicators().get(i));
            }

        }

    }

    /**
     * @Author:Yuyue
     * @Description:查询每一类别最新的文件
     * @Date:18:06 2019/11/22
     * @Param:
     * @Return:
     */
    @Override public List<TbDocument> selectLatestDocumentById(Integer patentId) {
        return patentMapper.selectLatestDocumentById(patentId);
    }

    /**
     * @Author:Yuyue
     * @Description:查询专利每一次上传的文件
     * @Date:18:07 2019/11/22
     * @Param:
     * @Return:
     */
    @Override public List<TbDocument> selectAllDocumentById(Integer patentId) {
        return patentMapper.selectAllDocumentById(patentId);
    }

    //修改

    /**
     * @Author:Yuyue
     * @Description:修改专利的进度
     * @Date:14:53 2019/11/24
     * @Param: 专利进度id，专利id
     * @Return:
     */
    @Override public void updatePatentPlan(TbPatent tbPatent) {
        patentMapper.updatePatentPlan(tbPatent);
    }

    //添加专利
    @Override public void addPatent(TbPatent tbPatent) {
        patentMapper.addPatent(tbPatent);
    }

    //根据专利名称查询专利信息
    @Override public TbPatent findPatentByName(String patentName) {
        return patentMapper.findPatentByName(patentName);
    }

    //根据专利id查询专利信息
    @Override public TbPatent findPatentById(Integer patentId) {
        return patentMapper.findPatentById(patentId);
    }

    //通过专利id修改专利进度
    @Override public void updPlan(TbPatent tbPatent) {
        patentMapper.updPlan(tbPatent);
    }

    /**
     * @Author:Yuyue
     * @Description:查询用户新建专利后，未通过的专利
     * @Date:15:21 2019/11/24
     * @Param:
     * @Return:
     */
    @Override public Page<TbPatent> getFailPatentByUser(Integer userId, int page, int rows) {
        PageHelper.startPage(page, rows);
        return patentMapper.getFailPatentByUser(userId);
    }

}
