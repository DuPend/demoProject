package com.xinghuo.service;


import com.xinghuo.pojo.TbUser;

import java.util.List;

public interface TbUserService {
    //增加用户
    int addUserServcie(TbUser tbUser);
    // 修改密码
    int updateUserService(TbUser tbUser);
    // 根据用户名查询
    TbUser showUserByNameService(String userName);
    //查询所有的用户信息
    List<TbUser> showAllUserService();

    /**
    *@Author:Yuyue
    *@Description:验证是否有这个用户
    *@Date:14:41  2019/12/3
    *@Param:
    *@Return:
    */
    Boolean selectUser(Integer userId);
}