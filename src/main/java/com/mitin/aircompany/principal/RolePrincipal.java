package com.mitin.aircompany.principal;

import com.mitin.aircompany.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;

public class RolePrincipal implements GrantedAuthority {
    private RoleEntity roleEntity;


    @Override
    public String getAuthority() {
        return roleEntity.name();
    }

    public RolePrincipal(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
