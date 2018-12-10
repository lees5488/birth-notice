package com.lee.birthnotice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BirthNoticeApplication {

  public static void main(String[] args) {
	SpringApplication.run(BirthNoticeApplication.class, args);
  }
}
