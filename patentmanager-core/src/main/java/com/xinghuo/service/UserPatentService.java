package com.xinghuo.service;

import com.github.pagehelper.Page;
import com.xinghuo.pojo.TbDocument;
import com.xinghuo.pojo.TbPatent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: demoProject
 * @description: 用户专利服务层
 * @author: Yuyue and  duanlian
 * @create: 2019-11-20 19:35
 **/

@Service
public interface UserPatentService {
    /*段炼*/
    Page<TbPatent> findAll(int page, int rows);
    /*段炼*/
    List<TbPatent> findDetail(Integer id);
    /*段炼*/
    int update(TbPatent tbPatent);

    //于悦
    Page<TbPatent> getPatentByUser(Integer userId, int page, int rows);
    //于悦
    TbPatent getPatentById(Integer patentId);
    //于悦
    void  updatePatentById(TbPatent tbPatent);
    //于悦
    List<TbDocument> selectLatestDocumentById(Integer patentId);
    //于悦
    List<TbDocument> selectAllDocumentById(Integer patentId);
    //修改
    /**
     *@Author:Yuyue
     *@Description:修改专利的进度
     *@Date:14:53  2019/11/24
     *@Param: 专利进度id，专利id
     *@Return:
     */
    void updatePatentPlan(TbPatent tbPatent);

    /**
     *@Author:Yuyue
     *@Description:查询是否有该专利
     *@Date:14:19  2019/12/3
     *@Param:
     *@Return:
     */
    Boolean selectPatent(Integer patentId);

    //添加专利   liujian
    void addPatent(TbPatent tbPatent);

    //根据专利名称查询专利信息  liujian
    TbPatent findPatentByName(String patentName);

    //根据专利id查询专利信息   liujian
    TbPatent findPatentById(Integer patentId);

    //通过专利id修改专利进度   liujian
    void updPlan(TbPatent tbPatent);

    /**
    *@Author:Yuyue
    *@Description:查询用户新建专利后，未通过的专利
    *@Date:15:21  2019/11/24
    *@Param:
    *@Return:
    */
    Page<TbPatent> getFailPatentByUser(Integer userId, int page, int rows);
}




