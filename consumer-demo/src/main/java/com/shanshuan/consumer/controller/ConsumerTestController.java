package com.shanshuan.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shanshuan.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wangzifeng on 2019/11/20.
 */
@RestController
@RequestMapping("test")
@DefaultProperties(defaultFallback = "fallback")
public class ConsumerTestController {

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



    @RequestMapping("{id}")
    @HystrixCommand(commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //阈值
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "20000"),//休眠时间窗 20s
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//达到百分比
    })
    public String getid(@PathVariable("id") Long id){
        String url="http://user-service/test/"+id;
        return restTemplate.getForEntity(url,User.class).getBody().toString();
    }

    /**
     * 服务降级 的 方法
     * @return
     */
    public String fallback(){
        return "服务器拥挤";
    }
}
