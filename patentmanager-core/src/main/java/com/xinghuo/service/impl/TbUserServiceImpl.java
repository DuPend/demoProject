package com.xinghuo.service.impl;

import com.xinghuo.mapper.TbUserMapper;
import com.xinghuo.pojo.TbUser;
import com.xinghuo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public int addUserServcie(TbUser tbUser) {
        return tbUserMapper.addUser(tbUser);
    }

    @Override
    public int updateUserService(TbUser tbUser) {
        return tbUserMapper.updateUser(tbUser);
    }

    @Override
    public TbUser showUserByNameService(String userName) {
        return tbUserMapper.showUserByName(userName);
    }

    @Override
    public List<TbUser> showAllUserService() {
        return tbUserMapper.showAllUser();
    }
}
