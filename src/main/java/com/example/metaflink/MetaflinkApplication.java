package com.example.metaflink;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.metaflink.mapper")
public class MetaflinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaflinkApplication.class, args);
    }
}
