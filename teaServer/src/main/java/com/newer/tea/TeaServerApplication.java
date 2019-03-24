package com.newer.tea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.newer.tea.mapper")
public class TeaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeaServerApplication.class, args);
	}

}
