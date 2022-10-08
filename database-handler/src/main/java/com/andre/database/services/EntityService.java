package com.andre.database.services;

import com.andre.database.entity.User;
import com.andre.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EntityService {

    @Autowired
    UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(String userId) {
        return repository.findById(userId).orElseThrow(RuntimeException::new);
    }
}
