package com.example.authorization.repository;

import com.example.authorization.authorities.Authorities;
import com.example.authorization.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        // для проверки
        users.put(1, new User("pavel", "23"));
        users.get(1).setAuthorities(Authorities.READ);
        users.get(1).setAuthorities(Authorities.WRITE);
        users.get(1).setAuthorities(Authorities.DELETE);

        for (User user1 : users.values()) {
            if (Objects.equals(user1.getName(), user) && user1.getPassword().equals(password)) {
                return user1.getAuthorities();
            }
        }
        return null;
    }
}
