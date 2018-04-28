package com.bbgame.common.web;

import com.bbgame.common.BaseDoing;
import com.bbgame.common.constants.CommonConstant;
import com.bbgame.common.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhangjh on 2017/10/10.
 */
@FunctionalInterface
public interface RestDoing<T> extends BaseDoing<T> {
    final Logger log = LoggerFactory.getLogger(RestDoing.class);

    default JsonResult<T> go(Logger log) {
        return this.invoke(null, null, null, null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, Logger log) {
        return this.invoke(null, null, r, null, log);
    }

    default JsonResult<T> go(HttpServletRequest r, ObjectMapper objectMapper, Logger log) {
        return this.invoke(null, null, r, objectMapper, log);
    }

    default JsonResult<T> go(Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        return this.invoke(null, visitor, request, objectMapper, log);
    }

    default JsonResult<T> go(Object inputData, Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        return this.invoke(inputData, visitor, request, objectMapper, log);
    }

    default JsonResult<T> invoke(Object inputData, Object visitor, HttpServletRequest request, ObjectMapper objectMapper, Logger log) {
        JsonResult<T> jr = new JsonResult();
        try {
            this.service(jr);
        } catch (BusinessException e) {
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (NoTransactionException e1) {
            }
            String code = e.getCode();
            if (StringUtils.isBlank(code)) {
                code = CommonConstant.CD_ERROR.getValue();
            }
            jr.errorParam(code, e.desc, log);
        } catch (Exception e) {
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (NoTransactionException e1) {
            }
            log.error("error happen:{}", e);
            jr.saveResult(CommonConstant.CD_ERROR.getValue(), log);
        } finally {
            this.showReturnData(jr, objectMapper, log);
        }

        LocalDateTime arrivalDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = arrivalDate.format(format);

        jr.setTimestamp(timestamp);
        return jr;
    }


    void service(JsonResult<T> jsonResult) throws Exception;

}
