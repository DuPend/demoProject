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
    List<TbPatent> findDetail(Integer patentId);
    /*段炼*/
    int update(TbPatent tbPatent);

    /**
     * 查询用户被认领的专利
     * @param userId   用户id
     * @param page    当前页
     * @param rows    一页显示多少条
     * @return  专利列表
     */
    Page<TbPatent> getPatentByUser(Integer userId, int page, int rows);

    /**
     * 专利详情
     * @param patentId 专利id
     * @return   专利详情
     */
    TbPatent getPatentById(Integer patentId);

    /**
     * 修改专利
     * @param tbPatent 专利对象
     */
    void  updatePatentById(TbPatent tbPatent);

    /**
     * 查询最新的专利
     * @param patentId 专利id
     * @return
     */
    List<TbDocument> selectLatestDocumentById(Integer patentId);

    /**
     * @Author:Yuyue
     * @Description:管理员查询出所有当前专利的文件
     * @Date:17:42 2019/11/22
     * @Param: 专利id
     * @Return: 返回文件list
     */
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




