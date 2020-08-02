package com.definesys.demo.service.impl;

import com.definesys.demo.bean.actor.pojo.ExportMdbActor;
import com.definesys.demo.bean.actor.pojo.MdbActor;
import com.definesys.demo.bean.actor.query.MdbActorQuery;
import com.definesys.demo.service.MdbActorService;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.MpaasQuery;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.definesys.mpaas.query.util.MpaasQueryUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MdbActorServiceImpl  extends BaseServiceImpl implements MdbActorService {
    @Override
    public Response pageQuery(MdbActorQuery query) {//分页查询
        MpaasQuery mpaasQuery = factory.buildViewQuery("v1");
        PageQueryResult<MdbActor> result = mpaasQuery
                .doPageQuery(query.getPage(), query.getPageSize(), MdbActor.class);//起始页，页面大小
        List<MdbActor> actors = result.getResult();//分页查询结果集

        return Response.ok().data(actors).setTotal(result.getCount().intValue());
    }

    @Override
    public Response getDetail(String rowId) {
        long id = Long.parseLong(MpaasQueryUtil.decryptRowId(rowId, config.rowIdSecret));//倚天解密rowId
        System.out.println(id);
        MdbActor mdbActor = factory.buildViewQuery("v1")
                .eq("id", id)
                .doQueryFirst(MdbActor.class);
        return Response.ok().data(mdbActor);
    }

    @Override
    public Response save(MdbActor actor) {
        String rowId = actor.getRowId();
        if(StringUtils.isEmpty(rowId)){//插入
            factory.buildQuery()
                    .doInsert(actor);
            //加密rowId
            rowId = MpaasQueryUtil.encryptRowId(actor.getRowId(), config.rowIdSecret);
        }else{//更新
            //解密rowId
            Long id = Long.parseLong(MpaasQueryUtil.decryptRowId(rowId, config.rowIdSecret));
            factory.buildQuery()
                    .eq("id",id)
                    .doUpdate(actor);
        }
        return Response.ok().data(rowId);
    }

    @Override
    public Response delete(String rowId) {
        Long id = Long.parseLong(MpaasQueryUtil.decryptRowId(rowId, config.rowIdSecret));
        factory.buildQuery()
                .eq("id",id)
                .doDelete(MdbActor.class);
        return Response.ok();
    }



    @Override
    public void export(MdbActorQuery query, HttpServletResponse response) {
        //导出接口、导出性能、部分导出
        factory.buildQuery()
                .like("name",query.getName())
                .include("name","pinyin","birthday","town","sex")
                .fileName("演员.xlsx")
                .doExport(response, ExportMdbActor.class);//导出类
    }
}
