package com.shanshuan.user.controller;

import com.shanshuan.user.pojo.User;
import com.shanshuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User queryByid(@PathVariable("id") Long id){
        return userService.queryById(id);
    }
}
