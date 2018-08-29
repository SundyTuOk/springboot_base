package com.tt.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// 如果不想在dao上面加@Mapper的话，这里就要加@MapperScan,但是这个MapperScan
// 是tk包里面的，不是ibatis里面的那个
//@MapperScan(basePackages = "com.tt.provider.dao")
public class Comsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Comsumer1Application.class, args);
	}
}
