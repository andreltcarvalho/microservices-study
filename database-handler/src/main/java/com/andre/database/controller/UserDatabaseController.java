package com.andre.database.controller;

import com.andre.database.entity.User;
import com.andre.database.services.EntityService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserDatabaseController {

    Logger logger = LoggerFactory.getLogger(UserDatabaseController.class);


    @Autowired
    EntityService service;

    @PostMapping
    public ResponseEntity<?> post(@NonNull @RequestBody User user) {
        logger.info("creating user: {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user));
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Getting all users.");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        logger.info("Getting user with ID: {}.", userId);
        return ResponseEntity.ok(service.findOne(userId));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> update(@NonNull @PathVariable String id, @NonNull @RequestBody User user) {
        return ResponseEntity.ok().body(service.update(user, id));
    }
}
