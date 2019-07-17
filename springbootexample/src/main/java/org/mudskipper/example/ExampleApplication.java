package org.mudskipper.example;

import org.mudskipper.blankparamcheck.annotation.EnableBlankParamCheck;
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
@EnableBlankParamCheck
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}

