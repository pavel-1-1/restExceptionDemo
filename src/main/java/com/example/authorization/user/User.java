package com.example.authorization.user;


import com.example.authorization.authorities.Authorities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private String password;

    private final List<Authorities> authorities = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities.add(authorities);
    }
}
