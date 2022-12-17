package com.tianhui;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tianhui.dao")
public class TianHuiBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(TianHuiBlogApplication.class, args);
    }

}
