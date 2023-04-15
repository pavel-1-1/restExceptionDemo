package com.example.authorization.repository;

import com.example.authorization.permission.Permission;
import com.example.authorization.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    public List<Permission> getUserAuthorities(String user, String password) {
        for (User user1 : users.values()) {
            if (Objects.equals(user1.getName(), user) && user1.getPassword().equals(password)) {
                return Collections.singletonList(user1.getPermission());
            }
        }
        return users.values().stream().map(User::getPermission).collect(Collectors.toList());
    }
}
