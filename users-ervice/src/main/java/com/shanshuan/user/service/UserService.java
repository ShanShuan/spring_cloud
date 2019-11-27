package com.shanshuan.user.service;

import com.shanshuan.user.mapper.UserMapper;
import com.shanshuan.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

}
