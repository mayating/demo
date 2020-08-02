package com.definesys.demo.bean.common.query;

import com.definesys.demo.util.StaticValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

/**
 * 基本的查询属性
 */
@ApiModel("分页查询基本查询类bean")
public class BasicQuery {


    /**
     * 请求的页面大小
     */
    @ApiModelProperty(value = "每页大小-非必输，默认为10",required = false,dataType = "Integer")
    private Integer pageSize;
    /**
     * 请求第几页
     */
    @ApiModelProperty(value = "请求第几页-非必输，默认为1",required = false,dataType = "Integer")
    private Integer page;
    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段-非必输",required = false,dataType = "String")
    private String orderCol;

    /**
     * 排序字段  应付项目池
     */
    @ApiModelProperty(value = "排序字段-非必输",required = false,dataType = "String")
    private String orderColName;


    /**
     * 排序类型  desc asc
     */
    @ApiModelProperty(value = "排序类型(desc/asc)-非必输，默认为asc",required = false,dataType = "String")
    private String orderType;

    private String searchValue;



    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize <= 0) {
            return StaticValue.PAGE_SIZE;
        } else {
            return pageSize;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderCol() {
        return orderCol;
    }

    public void setOrderCol(String orderCol) {
        this.orderCol = orderCol;
    }

    public String getOrderColName() {
        return orderColName;
    }

    public void setOrderColName(String orderColName) {
        this.orderColName = orderColName;
    }

    public String getOrderType() {
        if (StringUtils.isEmpty(this.orderType)) {
            return StaticValue.ORDER_TYPE;
        } else {
            return orderType;
        }

    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public Integer getPage() {
        if (this.page == null || this.page <= 0) {
            return StaticValue.PAGE_INDEX;
        } else {
            return page;
        }
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
