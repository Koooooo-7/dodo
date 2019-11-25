package com.koy.dodo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.koy.dodo.mapper")
public class DodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DodoApplication.class, args);
    }

}
