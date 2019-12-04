package com.xinghuo.mapper;

import com.xinghuo.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface TbUserMapper {
    //增加用户 liu_jian
    int addUser(TbUser tbUser);
    // 根据用户名查询  zhou_gc
    TbUser showUserByNameAndPassword(TbUser tbUser);
    //查询所有的用户信息 liu_jian
    List<TbUser> showAllUser();
    //更改用户登陆状态
    void updateUser(TbUser tbUser);

    TbUser selectUser(Integer userId);
}
