package com.ssafy.ssaccer.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.ssaccer.model.dao")
public class DBConfig {
}
