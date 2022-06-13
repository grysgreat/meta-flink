package com.example.metaflink;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.metaflink.mapper")
public class MetaflinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetaflinkApplication.class, args);
    }
}
