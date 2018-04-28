package com.bbgame.common.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjh on 2017/10/10.
 * 分页类
 */
@JsonIgnoreProperties(value = {"offset"})
public class PageResult<T> {
    public List<T> list = Lists.newArrayList();
    public Integer totalCount = 0;
    public Integer totalPage = 0;
    public Integer pageNo = 0;
    public Integer pageSize = 10;
    public Integer offset = 0;
    public String url;
    public String prevUrl;
    public String nextUrl;

    public PageResult() {
    }


    public PageResult(Integer pageNo, Integer pageSize, Long totalCount, List<T> list) {
        this.init(pageNo, pageSize, totalCount, list);
    }


    public PageResult(Integer pageNo, Integer pageSize, Long totalCount) {
        this(pageNo, pageSize, totalCount, null);
    }

    public PageResult(Integer pageNo, Integer pageSize) {
        this(pageNo, pageSize, null);
    }

    public void init(Integer pageNo, Integer pageSize, Long totalCount, List<T> list) {
        if (pageNo != null) {
            this.pageNo = pageNo;
        }
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
        if (this.pageNo.intValue() > 0) {
            this.offset = this.pageSize * this.pageNo;
        }
        if (totalCount != null) {
            this.totalCount = totalCount.intValue();
            totalPage = this.totalCount % pageSize > 0 ? this.totalCount / pageSize + 1 : this.totalCount / pageSize;
        }
        if (list != null) {
            this.list = list;
        }
    }


    public void setUrl(String url) {
        this.url = url;
        this.setPrevUrl(url + "?pageNo=" + (this.pageNo > 0 ? this.pageNo - 1 : 0) + "&pageSize=" + this.pageSize);
        this.setNextUrl(url + "?pageNo=" + (this.pageNo >= this.totalPage - 1 ? this.totalPage - 1 : this.pageNo + 1) + "&pageSize=" + this.pageSize);
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    private void setPrevUrl(String prevUrl) {
        this.prevUrl = prevUrl;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    private void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }
}
