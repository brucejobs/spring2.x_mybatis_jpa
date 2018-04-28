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
 */

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "sys_user_role")
public class UserRole extends BaseDomain {

    @Column(columnDefinition = "bigint")
    private int userId;

    @Column(columnDefinition = "bigint")
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
