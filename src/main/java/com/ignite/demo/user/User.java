package com.ignite.demo.user;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

public class User {
    private UserKey id;

    @QuerySqlField
    private String name;

    public User(String name) {
        this(new UserKey(), name);
    }

    public User(UserKey id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id.getId();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
