package com.shanshuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by wangzifeng on 2019/11/21.
 */

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
