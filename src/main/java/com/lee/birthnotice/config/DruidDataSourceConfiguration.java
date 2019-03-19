package com.lee.birthnotice.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.alibaba.druid.pool.DruidDataSource;

@Component
@Configuration
public class DruidDataSourceConfiguration {


  @Bean(name = "birthJdbcTemplate")
  public MyJdbcTemplate birthJdbcTemplate() {
	MyJdbcTemplate jdbcTemplate = new MyJdbcTemplate();
	jdbcTemplate.setDataSource(birthDataSource());
	return jdbcTemplate;
  }


  @Primary
  @Bean(name = "birthDataSource")
  @ConfigurationProperties("spring.datasource.druid.birth")
  public DruidDataSource birthDataSource() {
	DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
	//dataSource.setProxyFilters(getDuridFilters());
	return dataSource;
  }

}
