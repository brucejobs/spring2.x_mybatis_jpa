package com.bbgame.common.web;


import com.bbgame.common.exception.BusinessException;

/**
 * Created by zhangjh on 2017/10/10.
 */
public class BaseController {


    protected PageResult getPage(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        } else if (pageSize > 1000) {
            throw new BusinessException("2", "PageSize is too Large,it must be less than 1000");
        }

        return new PageResult(pageNo, pageSize);
    }
}
