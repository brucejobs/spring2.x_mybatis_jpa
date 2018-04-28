//package com.bbgame.authority.config;
//
//import com.github.pagehelper.PageHelper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.Properties;
//
///**
// * @Author bruce
// * @Date 2018/4/2 18:35
// * @Company bbgame
// * 数据分页处理
// */
//
//@Component
//@Configuration
//public class MyBatisPageInfo{
//    @Bean
//    public PageHelper pageHelper() {
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
//        p.setProperty("pageSizeZero", "true");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
//}
