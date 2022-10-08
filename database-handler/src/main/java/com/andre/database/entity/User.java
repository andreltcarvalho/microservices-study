package com.andre.database.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document
@Data
@Accessors(chain = true)
public class User {

    @Id
    private String userId;
    private String name;
    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();
}