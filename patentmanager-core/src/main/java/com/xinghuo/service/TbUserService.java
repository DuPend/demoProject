package com.xinghuo.service;


import com.xinghuo.pojo.TbUser;

import java.util.List;

public interface TbUserService {
    //增加用户 liu_jian
    int addUserServcie(TbUser tbUser);
    // 用户登陆 zhou_gc
    TbUser userLogin(TbUser tbUser);
    //查询所有的用户信息 liu_jian
    List<TbUser> showAllUserService();
    //更改登陆状态  zhou_gc
    void updateLoginStatus(TbUser tbUser);
}
