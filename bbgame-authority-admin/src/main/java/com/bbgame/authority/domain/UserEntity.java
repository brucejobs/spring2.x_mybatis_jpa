package com.bbgame.authority.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author bruce
 * @Date 2018/3/31 18:19
 * @Company bbgame
 * 用户id
 */

//@Entity
//@Table(name="bbgame_accout")
public class UserEntity {

    private Long id;

    //@Column(length = 50)
    private String account;

    //@Column(length = 25)
    private String password;

    //@Column(length = 80)
    private String email;

    //@Column(length = 30)
    private String mobile;

    //@Column(length = 50)
    private String nickName;

    //@Column(length = 60)
    private String devUniqueId;

    //@Column(length = 20)
    private String ip;

    //@Column(length = 10)
    private String status;

    //@Column(length = 50)
    private String uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getDevUniqueId() {
        return devUniqueId;
    }

    public void setDevUniqueId(String devUniqueId) {
        this.devUniqueId = devUniqueId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
