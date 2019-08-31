package com.ignite.demo.user;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

public class UserKey {
    @QuerySqlField(index = true)
    private UUID id;

    public UserKey() {
        this(UUID.randomUUID());
    }
    public UserKey(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
}
