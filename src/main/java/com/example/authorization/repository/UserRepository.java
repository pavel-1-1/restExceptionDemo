package com.example.authorization.repository;

import com.example.authorization.model.Authorities;
import com.example.authorization.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = Arrays.asList(
                new User("pavel", "23", Arrays.asList(Authorities.WRITE, Authorities.READ)),
                new User("roma", "34", Arrays.asList(Authorities.DELETE, Authorities.READ)),
                new User("sasha", "25", List.of(Authorities.READ)));
    }

    public Optional<List<Authorities>> getUserAuthorities(String user, String password) {
        for (User user1 : users) {
            if (user1.getName().equals(user) && user1.getPassword().equals(password)) {
                return Optional.of(user1.getAuthorities());
            }
        }
        return Optional.empty();
    }
}
