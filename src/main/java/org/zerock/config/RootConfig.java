package org.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//applicationContext or bean factory 가 사용할 설정 정보라는 의미
//
@Configuration
@ComponentScan(basePackages = {"org.zerock.sample"})
public class RootConfig {

}
