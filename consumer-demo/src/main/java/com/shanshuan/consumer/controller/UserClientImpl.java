package com.shanshuan.consumer.controller;

import com.shanshuan.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Created by wangzifeng on 2019/11/21.
 */
@Component
public class UserClientImpl implements UserClient{
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("为查询到用户");
        return user;
    }
}
