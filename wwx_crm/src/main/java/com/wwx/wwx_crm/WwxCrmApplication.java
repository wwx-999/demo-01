package com.wwx.wwx_crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wwx.wwx_crm.mapper")
public class WwxCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwxCrmApplication.class, args);
    }

}
