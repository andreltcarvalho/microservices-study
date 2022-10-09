package com.andre.api.services;

import com.andre.api.entity.User;
import com.andre.api.rest.Adapter;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class EntityService {

    @Autowired
    Adapter adapter;

    @Value("${database.host}")
    private String host;

    @Value("${database.port}")
    private int databasePort;

    public User createUser(User user) {
        log.info("CREATING USER: " + host + ":" + databasePort + "/user");
        log.info("BODY: \n" + new Gson().toJson(user));
        return adapter.buildAdapter()
                .post()
                .uri(String.format("%s:%s/user", host, databasePort))
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public User readUser(String id) {
        return adapter.buildAdapter()
                .get()
                .uri(String.format("%s:%s/user/%s", host, databasePort, id))
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public List readUsers() {
        return adapter.buildAdapter()
                .get()
                .uri(String.format("%s:%s/user", host, databasePort))
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

    public User updateUser(User user, String id) {
        return adapter.buildAdapter()
                .patch()
                .uri(String.format("%s:%s/user/%s", host, databasePort, id))
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
