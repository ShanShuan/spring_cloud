package com.shanshuan.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shanshuan.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancedRetryPolicy;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RibbonLoadBalancerClient client;

//    @RequestMapping("{id}")
//    public User getByid(@PathVariable("id") Long id){
//
////        return restTemplate.getForEntity("http://localhost:8081/user/"+id,User.class).getBody();
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////        ServiceInstance serviceInstance = instances.get(0);
//
////        ServiceInstance serviceInstance = client.choose("user-service");
////        String url ="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//        String url="http://user-service/user/"+id;
//        return restTemplate.getForEntity(url,User.class).getBody();
//    }



//    @RequestMapping("{id}")
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String getid(@PathVariable("id") Long id){
//        String url="http://user-service/user/"+id;
//        return restTemplate.getForEntity(url,User.class).getBody().toString();
//    }

    @Autowired
    private UserClient userClient;

    @RequestMapping("{id}")
    public String getxx(@PathVariable("id") Long id){
        return userClient.queryById(id).toString();
    }
    /**
     * 服务降级 的 方法   参数  和返回必须一致
     * @param id
     * @return
     */
    public String fallback(Long id){

        return "服务器拥挤";
    }
}
