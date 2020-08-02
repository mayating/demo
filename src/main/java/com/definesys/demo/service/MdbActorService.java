package com.definesys.demo.service;

import com.definesys.demo.bean.actor.pojo.MdbActor;
import com.definesys.demo.bean.actor.query.MdbActorQuery;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.conf.MpaasQueryConfig;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.definesys.mpaas.query.util.MpaasQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * service 接口类
 */

public interface MdbActorService {

    Response pageQuery(MdbActorQuery query);

    Response getDetail(String rowId);

    Response save(MdbActor actor);

    Response delete(String rowId);

    void export(MdbActorQuery query, HttpServletResponse response);
}
