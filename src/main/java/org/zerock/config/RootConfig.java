package org.zerock.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariJNDIFactory;

import lombok.extern.log4j.Log4j;

//applicationContext or bean factory 가 사용할 설정 정보라는 의미
@Configuration // <beans> </beans>
@PropertySource("classpath:/config/globals.properties")
@ComponentScan(basePackages = { "org.zerock.sample" })
public class RootConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		hikariConfig.setJdbcUrl(env.getProperty("jdbc.url"));
		hikariConfig.setUsername(env.getProperty("jdbc.username"));
		hikariConfig.setPassword(env.getProperty("jdbc.password"));

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		System.out.println(env.toString());
		return dataSource;

	}

}
