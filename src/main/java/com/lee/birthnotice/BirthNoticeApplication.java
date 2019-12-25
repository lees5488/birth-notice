package com.lee.birthnotice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@MapperScan(basePackages = "com.lee.birthnotice.mapper")
@SpringBootApplication
@EnableScheduling
public class BirthNoticeApplication {

  public static void main(String[] args) {
	SpringApplication.run(BirthNoticeApplication.class, args);
  }
}
