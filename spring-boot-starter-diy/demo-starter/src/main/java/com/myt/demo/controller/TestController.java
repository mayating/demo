package com.myt.demo.controller;

import com.myt.springboot.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-starter-diy
 * @description: 测试自定义starter中的service
 * @author: Ma YaTing
 * @create: 2020-10-20 22:04
 */
@RestController
public class TestController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHello("黎明");
    }
}
