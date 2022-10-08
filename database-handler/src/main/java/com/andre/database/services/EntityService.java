package com.andre.database.services;

import com.andre.database.entity.User;
import com.andre.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;


@Service
public class EntityService {

    @Autowired
    UserRepository repository;

    public User createUser(User user) {
        if (user.getCreationDate() == null) {
            user.setCreationDate(Date.from(Instant.now()));
        }
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(String userId) {
        return repository.findById(userId).orElseThrow(RuntimeException::new);
    }
}
