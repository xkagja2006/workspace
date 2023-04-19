package com.ssafy.sixboard.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan(basePackages = { "com.ssafy.board", "com.ssafy.util", "com.ssafy.aop.step06.annotation" })
@EnableAspectJAutoProxy
public class Config {
	@Bean	// 별도로 아이디를 주지 않으면 메소드 이름이 아이디가 됨.
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource(); // bean 객체 생성
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl(
				"jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		return dataSource;
	}

}
