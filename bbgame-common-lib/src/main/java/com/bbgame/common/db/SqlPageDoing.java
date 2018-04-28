package com.bbgame.common.db;

import com.bbgame.common.BaseDoing;
import com.bbgame.common.constants.CommonConstant;
import com.bbgame.common.web.PageResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjh on 2017/10/10.
 * 分页sql查询
 */
@FunctionalInterface
public interface SqlPageDoing<T> extends BaseDoing<T> {

    default PageResult<T> go(PageResult page, Class<T> clazz, ObjectMapper objectMapper, NamedParameterJdbcTemplate jdbcTemplate, Logger log) {
        Long startTime = System.currentTimeMillis();
        String className = CommonConstant.EMPTY.getValue();
        String methodName = CommonConstant.EMPTY.getValue();
        try {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            className = stackTraceElements[2].getFileName();
            methodName = stackTraceElements[2].getMethodName();
        } catch (Exception e) {
        }
        PageResult<T> outPage = new PageResult<>();
        StringBuilder sql = new StringBuilder();
        StringBuilder fields = new StringBuilder();

        Map<String, Object> params = new HashMap<>();

        // 数据库对应字段 字符串json 转换 对象
        Map<String, TypeReference> typeReferenceMap = new HashMap<>();
        try {
            this.service(sql, fields, params, typeReferenceMap);
            // 当如果没有自定义需要显示的字段,默认是 *
            if (fields.length() <= 0) {
                fields.append(CommonConstant.ASTERISK.getValue());
            }

            String countStrSql = sql.toString();

            if (countStrSql.indexOf(order_by) > 0) {
                int position = countStrSql.indexOf(order_by);
                countStrSql = countStrSql.substring(0, position);
            }

            // TODO System.out.println(MessageFormat.format("该域名{0}被访问了 {1} 次.", bean , iVisit));
            String countSql = countStrSql.replace(CommonConstant.PERCENT_S.getValue(), countField);

            String dataSql = sql.append(limit_offset).toString().replace(CommonConstant.PERCENT_S.getValue(), fields);

            this.showSql(params, countSqlName, countSql, log);
            Long count = jdbcTemplate.queryForObject(countSql, params, Long.class);
            if (count != null && count <= 0) {
                return outPage;
            }

            params.put(offset, page.offset);

            params.put(size, page.pageSize);
            this.showSql(params, dataSqlName, dataSql, log);

            RBeanPropertyRowMapper rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz);
            if (objectMapper != null) {
                rBeanPropertyRowMapper = new RBeanPropertyRowMapper(clazz, objectMapper, typeReferenceMap);
            }
            outPage.init(page.pageNo, page.pageSize, count, jdbcTemplate.query(dataSql, params, rBeanPropertyRowMapper));
        } catch (Exception e) {
            this.errorLog(log, e);
        } finally {
            long spendTime = System.currentTimeMillis() - startTime;
            if (spendTime > 1000) {
                log.info(sqlSpendformat, className, methodName, spendTime);
            }
        }
        return outPage;
    }

    default PageResult<T> go(PageResult page, Class<T> clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log) {

        return this.go(page, clazz, null, jdbcTemplate, log);
    }

    void service(StringBuilder sql, StringBuilder fields, Map<String, Object> params, Map<String, TypeReference> typeReferenceMap) throws ParseException;
}
