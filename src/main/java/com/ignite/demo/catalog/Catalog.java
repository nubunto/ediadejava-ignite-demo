package com.ignite.demo.catalog;

import java.util.UUID;

public class Catalog {
    private CatalogKey id;

    public Catalog(CatalogKey id) {
        this.id = id;
    }

    public Catalog() {
        this(new CatalogKey());
    }

    public UUID getId() {
        return id.getId();
    }
}
