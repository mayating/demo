package com.definesys.demo.bean.actor.pojo;

import com.definesys.mpaas.query.annotation.*;
import com.definesys.mpaas.query.json.MpaasDateDeserializer;
import com.definesys.mpaas.query.json.MpaasDateSerializer;
import com.definesys.mpaas.query.model.MpaasBasePojo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 演员表
 */
@SQLQuery(
        @SQL(view = "v1", sql="select t.id,t.name,t.pinyin,t.birthday,t.town,t.sex,t.description,t.avatar,t.object_version_number,t.created_by,t.creation_date,t.last_updated_by,t.last_update_date from mdb_actor t")
)
@ApiModel(value = "演员信息",description = "存储演员信息")         //Swagger插件 model层注解
@Table(value = "mdb_actor") //pojo关联到数据库表
public class MdbActor extends MpaasBasePojo {//继承该类后，会获得一个rowId字段

    //RowID 标识主键字段，pojo需要insert、update、delete操作时，必须指定RowId
    //RowID.sequence 主键类型为数字类型时，需要指定对应的sequence名称
    //RowID.type
    @RowID(sequence = "MDB_ACTOR_S", type = RowIDType.AUTO)
    @Column(value = "ID")
    private Integer id;

    @Style(displayName = "姓名",width = "50")
    @ApiModelProperty(value = "姓名")
    @Column(value = "NAME")
    private String name;

    @Style(displayName = "拼音",width = "30")
    @ApiModelProperty(value = "拼音")
    @Column(value = "PINYIN")
    private String pinyin;

    @Style(displayName = "生日",width = "50")
    @ApiModelProperty(value = "生日")
    @JsonSerialize(using = MpaasDateSerializer.class)
    @JsonDeserialize(using = MpaasDateDeserializer.class)
    private Date birthday;

    @Style(displayName = "城镇",width = "50")
    @ApiModelProperty(value = "城镇")
    @Column(value = "TOWN")
    private String town;

    @Style(displayName = "性别",width = "10")
    @ApiModelProperty(value = "性别")
    @Column(value = "SEX")
    private String sex;

    @Style(displayName = "描述",width = "100")
    @ApiModelProperty(value = "描述")
    @Column(value = "DESCRIPTION")
    private String description;

    @Style(displayName = "头像",width = "70")
    @ApiModelProperty(value = "头像")
    @Column(value = "AVATAR")
    private Long avatar;

    //SystemColumn 标识系统字段
    //Column 数据库命名--Java驼峰命名 映射
    @Style(displayName = "版本号",width = "30")
    @ApiModelProperty(value = "版本号")
    @SystemColumn(SystemColumnType.OBJECT_VERSION)
    @Column(value = "object_version_number")
    private Integer objectVersionNumber;

    @Style(displayName = "创建者",width = "50")
    @ApiModelProperty(value = "创建者")
    @SystemColumn(SystemColumnType.CREATE_BY)
    @Column(value = "created_by")
    private String createdBy;

    @Style(displayName = "创建时间",width = "50")
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = MpaasDateSerializer.class)
    @JsonDeserialize(using = MpaasDateDeserializer.class)
    @SystemColumn(SystemColumnType.CREATE_ON)
    @Column(value = "creation_date")
    private Date creationDate;

    @Style(displayName = "最后更新人",width = "50")
    @ApiModelProperty(value = "最后更新人")
    @SystemColumn(SystemColumnType.LASTUPDATE_BY)
    @Column(value = "last_updated_by")
    private String lastUpdatedBy;

    @Style(displayName = "最后更新时间",width = "50")
    @ApiModelProperty(value = "最后更新时间")
    @JsonSerialize(using = MpaasDateSerializer.class)
    @JsonDeserialize(using = MpaasDateDeserializer.class)
    @SystemColumn(SystemColumnType.LASTUPDATE_ON)
    @Column(value = "last_update_date")
    private Date lastUpdateDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAvatar() {
        return avatar;
    }

    public void setAvatar(Long avatar) {
        this.avatar = avatar;
    }

    public Integer getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Integer objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
