package com.bbgame.authority.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author bruce
 * @Date 2018/4/28 16:58
 * @Company bbgame
 * 资源信息表
 */

@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "sys_resources")
public class Resource extends BaseDomain {

    @Column(columnDefinition = "varchar(50)")
    private String name;

    @Column(columnDefinition = "smallint")
    private int type;

    @Column(columnDefinition = "smallint")
    private int parentId;

    @Column(columnDefinition = "varchar(8)")
    private String sort;

    @Column(columnDefinition = "varchar(255)")
    private String detail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
