package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.spring.springboot.dao")
@EnableCaching
public class SpringbootMybatisRedisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisRedisAnnotationApplication.class, args);
	}

}
