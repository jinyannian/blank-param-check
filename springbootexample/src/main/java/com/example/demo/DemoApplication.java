package com.example.demo;

import top.mudskipper.blankparamcheck.annotation.EnableBlankParameterCheck;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("org.mudskipper.example.dao")
@EnableConfigurationProperties
@EnableScheduling  // 开启定时器
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableBlankParameterCheck
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

