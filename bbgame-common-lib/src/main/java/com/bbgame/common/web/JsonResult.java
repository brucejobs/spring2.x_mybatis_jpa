package com.bbgame.common.web;

import com.bbgame.common.constants.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhangjh on 2017/10/10.
 */
public class JsonResult<T> {

    public String code = CommonConstant.CD0[0];
    public String desc = CommonConstant.CD0[1];
    public String timestamp;
    public T data;


    public JsonResult() {
    }


    public JsonResult(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    private void saveJsonResult(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void errorParam(String desc, Logger log) {
        this.code = CommonConstant.CD2[0];
        this.desc = CommonConstant.CD2[1] + desc;
        log.error("errorParam , desc : {}", desc);

    }

    public void errorParam(String code, String desc, Logger log) {
        custom(code, desc, log);
    }

    public void custom(String code, String desc, Logger log) {
        this.code = code;
        this.desc = desc;
        log.error("custom , code : {} , desc : {}", code, desc);
    }


    public void saveResult(String codeInput, Logger log) {
        saveResult(codeInput, null, null);
    }

    public void saveResult(String codeInput, String desc, Logger log) {
        switch (codeInput) {
            case "CD0":
                saveJsonResult(CommonConstant.CD0[0], CommonConstant.CD0[1]);
                break;
            default:
                saveJsonResult(CommonConstant.CD1[0], CommonConstant.CD1[1]);
                break;

        }

        if (StringUtils.isNotBlank(desc)) {
            setDesc(desc);
        }
        if (null != log) {
            log.error(" code : {} , desc : {}", getCode(), getDesc());
        }


    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void go(Logger logger) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement s : stackTrace) {
            logger.error(s.getClassName() + ",-" + s.getMethodName() + ":["
                    + " " + s.getLineNumber() + "]");
        }
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }

    public JsonResult build(String code, String desc) {
        this.code = code;
        this.desc = desc;
        LocalDateTime arrivalDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = arrivalDate.format(format);
        this.timestamp = timestamp;

        return this;
    }


}
