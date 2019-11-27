package com.shanshuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.shanshuan.**.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
