package com.bbgame.common.exception;

/**
 * Created by zhangjh on 2017/10/10.
 */
public class BusinessException extends RuntimeException {

    public String code;

    public String desc;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BusinessException(String desc) {
        this.desc = desc;
    }

    public BusinessException(String code, String desc) {
        super(desc);
        this.desc = desc;
        this.code = code;
    }

}
