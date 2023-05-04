package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zyy
 * @version 1.0.0
 * @ClassName ServiceAuthApplication.java
 * @Description TODO
 * @createTime 2023年03月07日 21:05:00
 */
@SpringBootApplication
@ComponentScan("com.tedu")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}
