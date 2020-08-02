package com.definesys.demo.controller;

import com.definesys.demo.bean.actor.pojo.MdbActor;
import com.definesys.demo.bean.actor.query.MdbActorQuery;
import com.definesys.demo.service.MdbActorService;
import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.db.PageQueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;


@Api(description = "演员模块接口", tags = "演员模块接口")//swagger插件 controller层注解
@RestController
@RequestMapping("/api/actor")
public class MdbActorController {

    @Autowired
    private MdbActorService mdbActorService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/pageQuery")
    public Response pageQuery(@ApiParam("演员查询类") @RequestBody MdbActorQuery query){
        return mdbActorService.pageQuery(query);
    }

    @ApiOperation("获取单个详情")
    @GetMapping("/getDetail")
    public Response queryById(@RequestParam String rowId){
        return mdbActorService.getDetail(rowId);
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public Response save(@ApiParam("演员类") @RequestBody MdbActor actor){
        return mdbActorService.save(actor);
    }

    @ApiOperation("删除")
    @GetMapping("/delete")
    public Response delete(@RequestParam String rowId){
        return mdbActorService.delete(rowId);
    }


    @ApiOperation("导出Excel")
    @GetMapping("/export")
    public void export(@ApiParam("演员查询类") @RequestBody MdbActorQuery query){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        response.setCharacterEncoding("UTF-8");
        mdbActorService.export(query,response);
    }

}
