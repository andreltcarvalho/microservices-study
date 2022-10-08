package com.andre.database.controller;

import com.andre.database.entity.User;
import com.andre.database.services.EntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    EntityService service;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody User user) {
        logger.info("creating user: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Getting all users.");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        logger.info("Getting user with ID: {}.", userId);
        return ResponseEntity.ok(service.findOne(userId));
    }

    @GetMapping(value = "/log")
    public String log() {
       logger.trace("This is a TRACE level message");
       logger.debug("This is a DEBUG level message");
       logger.info("This is an INFO level message");
       logger.warn("This is a WARN level message");
       logger.error("This is an ERROR level message");
        return "See the log for details";
    }
}
