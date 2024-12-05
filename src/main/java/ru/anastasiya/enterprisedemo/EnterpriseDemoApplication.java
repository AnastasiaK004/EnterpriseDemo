package ru.anastasiya.enterprisedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

@SpringBootApplication
public class EnterpriseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseDemoApplication.class, args);
    }

}
