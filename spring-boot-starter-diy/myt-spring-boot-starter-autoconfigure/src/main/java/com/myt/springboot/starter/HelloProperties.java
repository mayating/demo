package com.myt.springboot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring-boot-starter-diy
 * @description: 配置类
 * @author: Ma YaTing
 * @create: 2020-10-20 20:19
 */
//前缀 myt.hello
@ConfigurationProperties(prefix = "myt.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
