package com.bbgame.authority;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @Author bruce
 * @Date 2018/3/31 18:21
 * @Company bbgame
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class, GsonAutoConfiguration.class, JmxAutoConfiguration.class})
//@ServletComponentScan //扫描自定义servlet
//@MapperScan("com.bbgame.authority.dao")
public class BootStrapAdminApi {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(BootStrapAdminApi.class);
        app.setBannerMode(Banner.Mode.LOG);
        ApplicationContext applicationContext = app.run(args);

    }
}