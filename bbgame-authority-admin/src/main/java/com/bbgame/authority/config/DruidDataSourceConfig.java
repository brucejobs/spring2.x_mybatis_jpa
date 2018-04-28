package com.bbgame.authority.config;

//@Configuration
//@ConditionalOnClass({DruidDataSource.class})
//@ConditionalOnProperty(name = {"spring.datasource.type"}, havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true
//)
//@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DruidDataSourceConfig {

//    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);
//
//    @Bean
//    public ServletRegistrationBean druidServlet(DruidDataSourceProperties druidDataSourceProperties) {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings(Routes.API_VERSION + "/druid/*");
//        reg.addInitParameter("loginUsername", "BBGame2018");
//        reg.addInitParameter("loginPassword", "Goodjob@bbgame123");
//        reg.addInitParameter("logSlowSql", "true");
//        return reg;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public DataSource druidDataSource(DruidDataSourceProperties druidDataSourceProperties) {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(druidDataSourceProperties.getUrl());
//        datasource.setUsername(druidDataSourceProperties.getUsername());
//        datasource.setPassword(druidDataSourceProperties.getPassword());
//        datasource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
//        datasource.setInitialSize(druidDataSourceProperties.getInitialSize());
//        datasource.setMinIdle(druidDataSourceProperties.getMinIdle());
//        datasource.setMaxActive(druidDataSourceProperties.getMaxActive());
//        datasource.setMaxWait(druidDataSourceProperties.getMaxWait());
//        datasource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.getTimeBetweenEvictionRunsMillis());
//        datasource.setMinEvictableIdleTimeMillis(druidDataSourceProperties.getMinEvictableIdleTimeMillis());
//        datasource.setValidationQuery(druidDataSourceProperties.getValidationQuery());
//        datasource.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
//        datasource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
//        datasource.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
//        datasource.setConnectionProperties(druidDataSourceProperties.getConnectionProperties());
//        try {
//            datasource.setFilters(druidDataSourceProperties.getFilters());
//        } catch (SQLException e) {
//            logger.error("druid configuration initialization filter", e);
//        }
//        return datasource;
//    }

}
