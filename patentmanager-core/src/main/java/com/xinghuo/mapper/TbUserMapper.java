package com.xinghuo.mapper;

import com.xinghuo.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface TbUserMapper {
    //增加用户
    int addUser(TbUser tbUser);
    // 修改密码
    int updateUser(TbUser tbUser);
    // 根据用户名查询
    TbUser showUserByName(String userName);
    //查询所有的用户信息
    List<TbUser> showAllUser();
}
