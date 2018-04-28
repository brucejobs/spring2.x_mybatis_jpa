package com.bbgame.common.bean;

import com.alibaba.fastjson.JSON;
import com.bbgame.common.bean.enums.UserOpenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 平台用户表
 */
@Entity
@Table(name = "usr_account")
@DynamicInsert
@DynamicUpdate
public class User extends BaseDomain {

    @Column(columnDefinition = "varchar(30) comment '手机号码'")
    private String mobile = "";

    @Column(columnDefinition = "varchar(150) comment '玩家昵称'")
    private String nickName = "";

    @Column(columnDefinition = "varchar(120) comment '注册邮箱'")
    private String email = "";

    @JsonIgnore
    @Column(columnDefinition = "varchar(100) comment '账号密码'")
    private String password;

    @Column(columnDefinition = "smallint comment '状态'")
    private int state = 0;

    @Column(columnDefinition = "varchar(120) comment '玩家账号'")
    private String account;

    @Column(columnDefinition = "varchar(30) comment '登录类型'")
    @Enumerated(EnumType.STRING)
    private UserOpenType openType;


    @Column(columnDefinition = "varchar(100) comment '设备号'")
    private String devUniqueId = "";


    @Column(columnDefinition = "varchar(32) comment '唯一用户编号'")
    private String uid;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public UserOpenType getOpenType() {
        return openType;
    }

    public void setOpenType(UserOpenType openType) {
        this.openType = openType;
    }

    public String getDevUniqueId() {
        return devUniqueId;
    }

    public void setDevUniqueId(String devUniqueId) {
        this.devUniqueId = devUniqueId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }

}
