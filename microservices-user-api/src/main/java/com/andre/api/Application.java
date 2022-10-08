package com.andre.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    Environment environment;

    @RequestMapping("/")
    public String home() {
        logger.debug("Chamada:"+environment.getProperty("local.server.port"));
        return "Hello Docker World";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
