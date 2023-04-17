package com.example.authorization.service;

import com.example.authorization.exceptionHandler.InvalidCredentials;
import com.example.authorization.exceptionHandler.UnauthorizedUser;
import com.example.authorization.model.Authorities;
import com.example.authorization.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        Optional<List<Authorities>> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (userAuthorities.isEmpty()) {
            throw new UnauthorizedUser("Unknown user");
        }
        return userAuthorities.get();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
