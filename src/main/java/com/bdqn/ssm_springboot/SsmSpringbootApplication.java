package com.bdqn.ssm_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.bdqn.ssm_springboot.dao")
@SpringBootApplication
public class SsmSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmSpringbootApplication.class, args);
	}

}
