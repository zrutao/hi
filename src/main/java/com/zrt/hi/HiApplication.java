package com.zrt.hi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiApplication {

    public static void main(String[] args) {
        System.out.println("代码运行");
        SpringApplication.run(HiApplication.class, args);
    }

}
