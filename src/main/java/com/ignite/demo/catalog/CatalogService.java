package com.ignite.demo.catalog;

import com.ignite.demo.user.User;
import com.ignite.demo.user.UserKey;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CatalogService {
    private final IgniteCache<CatalogKey, Catalog> cache;

    private SqlFieldsQuery insertCatalog = new SqlFieldsQuery("INSERT INTO catalog (id) VALUES (?)");
    private SqlFieldsQuery selectCatalog = new SqlFieldsQuery("SELECT id FROM catalog");

    public CatalogService(IgniteCache<CatalogKey, Catalog> cache) {
        this.cache = cache;
    }

    public void create(Catalog catalog) {
        cache.query(insertCatalog.setArgs(catalog.getId()));
    }

    public List<Catalog> fetchAll() {
        List<Catalog> catalogs = new ArrayList<>();
        try(QueryCursor<List<?>> cursor = cache.query(selectCatalog)) {
            for(List<?> row : cursor) {
                Catalog catalog = new Catalog(new CatalogKey((UUID)row.get(0)));
                catalogs.add(catalog);
            }
        }
        return catalogs;
    }

    public void createItemInCatalog() {}
}
