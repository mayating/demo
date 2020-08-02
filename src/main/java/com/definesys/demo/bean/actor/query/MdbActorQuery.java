package com.definesys.demo.bean.actor.query;

import com.definesys.demo.bean.common.query.BasicQuery;
import com.definesys.mpaas.query.annotation.Column;
import com.definesys.mpaas.query.annotation.Style;
import com.definesys.mpaas.query.json.MpaasDateDeserializer;
import com.definesys.mpaas.query.json.MpaasDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;

import java.util.Date;


@ApiModel("演员查询类")
public class MdbActorQuery extends BasicQuery {

    @Style(displayName = "姓名",width = "50")
    @Column(value = "NAME")
    private String name;

    @Style(displayName = "拼音",width = "30")
    @Column(value = "PINYIN")
    private String pinyin;

    @Style(displayName = "生日",width = "50")
    @JsonSerialize(using = MpaasDateSerializer.class)
    @JsonDeserialize(using = MpaasDateDeserializer.class)
    private Date birthday;

    @Style(displayName = "城镇",width = "50")
    @Column(value = "TOWN")
    private String town;

    @Style(displayName = "性别",width = "10")
    @Column(value = "SEX")
    private String sex;

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
}
