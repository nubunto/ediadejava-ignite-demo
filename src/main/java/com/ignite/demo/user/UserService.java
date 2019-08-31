package com.ignite.demo.user;

import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private IgniteCache<UserKey, User> cache;
    private final SqlFieldsQuery insertUser = new SqlFieldsQuery("INSERT INTO user (id, name) VALUES (?, ?)");
    private final SqlFieldsQuery selectUsers = new SqlFieldsQuery("SELECT id, name FROM user");

    public UserService(IgniteCache<UserKey, User> cache) {
        this.cache = cache;
    }

    public void create(User user) {
        cache.query(insertUser.setArgs(user.getId(), user.getName()));
    }

    public List<User> fetchAll() {
        List<User> users = new ArrayList<>();
        try(QueryCursor<List<?>> cursor = cache.query(selectUsers)) {
            for(List<?> row : cursor) {
                User user = new User(new UserKey((UUID)row.get(0)), (String)row.get(1));
                users.add(user);
            }
        }
        return users;
    }
}
