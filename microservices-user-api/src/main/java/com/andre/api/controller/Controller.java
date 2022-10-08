package com.andre.api.controller;

import com.andre.api.entity.User;
import com.andre.api.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controller {

    @Autowired
    EntityService service;

    @PostMapping("user/create")
    public ResponseEntity<?> post(@RequestBody User user) {
        return ResponseEntity.ok().body(service.createUser(user));
    }
}
