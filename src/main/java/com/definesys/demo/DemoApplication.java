package com.definesys.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication() //启动类
@ComponentScan(basePackages = {"com.definesys.mpaas","com.definesys.demo"})//倚天
@EnableTransactionManagement //事务管理
@EnableSwagger2 //swagger接口文档插件
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);//启动应用程序
    }
}
