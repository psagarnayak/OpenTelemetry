package com.demo.otlp.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CustomerApp {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApp.class, args);
    }
}
