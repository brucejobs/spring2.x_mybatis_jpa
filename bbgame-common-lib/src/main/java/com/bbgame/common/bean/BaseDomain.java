package com.bbgame.common.bean;

import com.bbgame.common.bean.enums.Whether;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhanjgh on 2017/10/13.
 */
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)//如果为空的属性，去除
@JsonIgnoreProperties(value = {"updateTime", "deleteFlag", "version"})
public class BaseDomain {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /**
     * 新建时间
     */
    @Column(columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间'")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdTime;

    /**
     * 更新时间
     */
    @Column(columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间'")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;

    /**
     * 是否逻辑删除
     */
    @Column(columnDefinition = "varchar (4) default 'NO' comment '是否逻辑删除 (是:YES,否:NO)'")
    @Enumerated(EnumType.STRING)
    protected Whether deleteFlag = Whether.NO;

    /**
     *
     */
    @Column
    @Version
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
