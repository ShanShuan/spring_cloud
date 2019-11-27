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
@RequestMapping("test")
public class UserTestController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public User queryByid(@PathVariable("id") Long id){
        if(id==1){
            throw  new RuntimeException("");
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.queryById(id);
    }
}
