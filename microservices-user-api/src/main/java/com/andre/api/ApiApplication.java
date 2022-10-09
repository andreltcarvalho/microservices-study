package com.andre.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

    Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
