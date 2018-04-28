package com.bbgame.authority.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author bruce
 * @Date 2018/4/28 16:54
 * @Company bbgame
 * 角色信息表
 */

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "sys_role")
public class Role extends BaseDomain {

    @Column(columnDefinition = "varchar(50)")
    private String name;

    @Column(columnDefinition = "varchar(255)")
    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
