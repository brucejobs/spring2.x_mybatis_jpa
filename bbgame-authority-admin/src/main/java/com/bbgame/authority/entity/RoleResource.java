package com.bbgame.authority.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author bruce
 * @Date 2018/4/28 16:58
 * @Company bbgame
 * 角色资源表
 */

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "sys_role_resources")
public class RoleResource extends BaseDomain {

    @Column(columnDefinition = "bigint")
    private int roleId;

    @Column(columnDefinition = "smallint")
    private int type;

    @Column(columnDefinition = "smallint")
    private int parentId;

    @Column(columnDefinition = "varchar(255)")
    private String detail;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
