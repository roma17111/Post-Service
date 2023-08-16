package com.service.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostServiceApplication.class, args);
    }

    String dbUser = System.getenv("DB_USER");
    String dbPassword = System.getenv("DB_PASSWORD");
    String dbBase = System.getenv("DB_DATABASE");

}
