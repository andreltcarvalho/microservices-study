package com.andre.database.config;

import org.springframework.boot.actuate.mongo.MongoHealthIndicator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class HealthIndicator extends MongoHealthIndicator {

    public HealthIndicator(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }
}
