package com.ignite.demo.catalog;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.util.UUID;

public class CatalogKey {
    @QuerySqlField(index = true)
    private UUID id;

    public CatalogKey(UUID id) {
        this.id = id;
    }

    public CatalogKey() {
        this(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }
}
