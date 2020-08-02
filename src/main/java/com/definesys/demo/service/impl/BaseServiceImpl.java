package com.definesys.demo.service.impl;

import com.definesys.mpaas.log.SWordLogger;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.conf.MpaasQueryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注入通用的组件
 */
@Component
public class BaseServiceImpl {

    @Autowired
    public MpaasQueryFactory factory;

    @Autowired
    public SWordLogger logger;

    @Autowired
    MpaasQueryConfig config;
}
