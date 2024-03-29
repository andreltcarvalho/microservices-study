package com.andre.api.controller;

import com.andre.api.entity.User;
import com.andre.api.services.EntityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserApiController {

    @Autowired
    EntityService userService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "MICROSERVICES_TOPIC";

    @PostMapping("/create")
    public ResponseEntity<?> post(@NonNull @RequestBody User user) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC, new ObjectMapper().writeValueAsString(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<?> read(@NonNull @PathVariable String userId) {
        return ResponseEntity.ok().body(userService.readUser(userId));
    }

    @GetMapping("/read")
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok().body(userService.readUsers());
    }

    @PatchMapping("/update/{userId}")
    public ResponseEntity<?> update(@NonNull @PathVariable String userId, @NonNull @RequestBody User user) {
        return ResponseEntity.ok().body(userService.updateUser(user, userId));
    }
}
