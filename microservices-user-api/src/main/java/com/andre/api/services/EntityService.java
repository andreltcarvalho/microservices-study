package com.andre.api.services;

import com.andre.api.entity.User;
import com.andre.api.rest.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EntityService {

    @Autowired
    Adapter adapter;

    public User createUser(User user) {
        return adapter.buildAdapter()
                .post()
                .uri("localhost:8080/user/realCreate")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
