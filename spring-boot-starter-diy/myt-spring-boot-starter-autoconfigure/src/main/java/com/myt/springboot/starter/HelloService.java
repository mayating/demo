package com.myt.springboot.starter;

/**
 * @program: spring-boot-starter-diy
 * @description: 自己的服务
 * @author: Ma YaTing
 * @create: 2020-10-20 20:19
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties(){
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties){
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
        return helloProperties.getPrefix() + name + helloProperties.getSuffix();
    }
}
