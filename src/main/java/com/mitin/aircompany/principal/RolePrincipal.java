package com.mitin.aircompany.principal;

import org.springframework.security.core.GrantedAuthority;

public enum RolePrincipal implements GrantedAuthority {
    USER, ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
