package com.bbgame.common.db;

import com.bbgame.common.BaseDoing;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjh on 2017/10/10.
 * 自定义删除、修改、插入数据库操作接口类
 */
@FunctionalInterface
public interface SqlUpdateDoing<T> extends BaseDoing<T> {
    default T go(Class clazz, NamedParameterJdbcTemplate jdbcTemplate, Logger log, ObjectMapper objectMapper) {
        Long startTime = System.currentTimeMillis();
        StringBuffer sql = new StringBuffer();
        StringBuffer fields = new StringBuffer();
        Map<String, Object> params = new HashMap<>();
        T object = null;

        // 数据库对应字段 字符串json 转换 对象
        Map<String, TypeReference> typeReferenceMap = new HashMap<>();
        try {

            this.service(sql, fields, params, typeReferenceMap);
            String dataSql = sql.toString();
            if (fields.length() >= 1) {
                dataSql = String.format(sql.toString(), fields);
            }
            this.showSql(params, dataSqlName, dataSql, log);
            jdbcTemplate.update(dataSql, params);
        } catch (IncorrectResultSetColumnCountException e) { // 证明id 对应的记录为空

        } catch (Exception e) {
            this.showErrorLog(e, log);
        } finally {
            long spendTime = System.currentTimeMillis() - startTime;
            if (spendTime > 1000) {
                log.info(sqlSpendformat, "", "", spendTime);
            }
        }
        return object;
    }

    void service(StringBuffer sql, StringBuffer fields, Map<String, Object> params, Map<String, TypeReference> typeReferenceMap);

}
