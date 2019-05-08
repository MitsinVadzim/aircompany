package com.mitin.aircompany.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private Long id;

    private String username;

    private String password;

    private Set<Role> roles;

    private String email;

    public User() {
    }

    public User(Long id, String username, String password, String email, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
}
