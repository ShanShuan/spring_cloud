package com.shanshuan.consumer.controller;

import com.shanshuan.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by wangzifeng on 2019/11/21.
 */
@FeignClient(value = "user-service",fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);
}
