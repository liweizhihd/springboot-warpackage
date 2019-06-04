package com.example.warpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"file:config/application.properties"})
public class WarpackageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarpackageApplication.class, args);
    }

}
