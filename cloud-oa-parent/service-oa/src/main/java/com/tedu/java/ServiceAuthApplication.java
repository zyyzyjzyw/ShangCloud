package com.tedu.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName ServiceAuthApplication.java
 * @Description TODO
 * @createTime 2023年03月07日 21:05:00
 */
@SpringBootApplication
@MapperScan("com.tedu.java.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
