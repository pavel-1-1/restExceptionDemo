package com.example.authorization.user;


import com.example.authorization.permission.Permission;

public class User {

    private String name;

    private String password;

    private Permission permission;

    public User(String name, String password, Permission permission) {
        this.name = name;
        this.password = password;
        this.permission = permission;
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

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
