package com.demo.otlp.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RentalApp {

    public static void main(String[] args) {
        SpringApplication.run(RentalApp.class, args);
    }
}
