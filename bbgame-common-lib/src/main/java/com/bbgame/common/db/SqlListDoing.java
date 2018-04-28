package com.bbgame.common.db;

import com.bbgame.common.BaseDoing;
import com.bbgame.common.constants.CommonConstant;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * Created by zhangjh on 2017/10/10.
 * 列表查询
 */
public interface SqlListDoing<T> extends BaseDoing<T> {

    default List<T> go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper) {
        Long startTime = System.currentTimeMillis();
        String className = CommonConstant.EMPTY.getValue();
        String methodName = CommonConstant.EMPTY.getValue();
        try {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            className = stackTraceElements[3].getFileName();
            methodName = stackTraceElements[3].getMethodName();
        } catch (Exception e) {
        }
        List<T> result = Lists.newArrayList();
        StringBuffer sql = new StringBuffer();
        StringBuffer fields = new StringBuffer();
        Map<String, Object> params = new HashMap<>();

        // 数据库对应字段 字符串json 转换 对象
        Map<String, TypeReference> typeReferenceMap = new HashMap<>();
        try {

            this.service(sql, fields, params, typeReferenceMap);
            String dataSql = sql.toString();
            if (fields.length() >= 1) {
                dataSql = dataSql.replace(CommonConstant.PERCENT_S.getValue(), fields);
            }
            if (clazz == String.class || clazz == Long.class || clazz == Double.class || clazz == Float.class || clazz == Integer.class || clazz == BigDecimal.class || clazz == Date.class) {
                result = jdbcTemplate.queryForList(dataSql, params, clazz);
            } else {
                RowMapper rowMapper = new BeanPropertyRowMapper<>(clazz);
                if (typeReferenceMap.size() > 0) {
                    rowMapper = new RBeanPropertyRowMapper<T>(clazz, objectMapper, typeReferenceMap);
                }
                result = jdbcTemplate.query(dataSql, params, rowMapper);
            }

        } catch (IncorrectResultSetColumnCountException e) { // 证明id 对应的记录为空

        } catch (Exception e) {
            this.showErrorLog(e, log);
        } finally {
            long spendTime = System.currentTimeMillis() - startTime;
            if (spendTime > 1000) {
                log.info(sqlSpendformat, className, methodName, spendTime);
            }
        }
        return result;
    }

    /**
     * 调转参数位置,统一一下
     *
     * @param clazz
     * @param objectMapper
     * @param jdbcTemplate
     * @param log
     * @return
     */
    default List<T> go(Class clazz, ObjectMapper objectMapper, NamedParameterJdbcTemplate jdbcTemplate, Logger log) {
        return this.go(clazz, jdbcTemplate, log, objectMapper);
    }

    void service(StringBuffer sql, StringBuffer fields, Map<String, Object> params, Map<String, TypeReference> typeReferenceMap) throws ParseException;
}
