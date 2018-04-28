package com.bbgame.authority.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bbgame.common.bean.enums.Whether;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhanjgh on 2017/10/13.
 */
@MappedSuperclass
public class BaseDomain {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 新建时间
     */
    @JSONField(serialize = false,format="yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间'")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdTime;

    /**
     * 更新时间
     */
    @JSONField(serialize = false,format="yyyy-MM-dd HH:mm:ss")
    @Column(columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间'")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;

    /**
     * 是否逻辑删除
     */
    @JSONField(serialize = false)
    @Column(columnDefinition = "varchar (4) default 'NO' comment '是否逻辑删除 (是:YES,否:NO)'")
    @Enumerated(EnumType.STRING)
    protected Whether deleteFlag = Whether.NO;

    /**
     *
     */
    @Column
    @Version
    @JSONField(serialize = false)
    protected Long version = 0L;


    public BaseDomain() {
    }

    public BaseDomain(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Whether getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Whether deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseDomain)) {
            return false;
        }

        BaseDomain that = (BaseDomain) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(createdTime, that.createdTime)
                .append(updateTime, that.updateTime)
                .append(deleteFlag, that.deleteFlag)
                .append(version, that.version)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(createdTime)
                .append(updateTime)
                .append(deleteFlag)
                .append(version)
                .toHashCode();
    }
}
