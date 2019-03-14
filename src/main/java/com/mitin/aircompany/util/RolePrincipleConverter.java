package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.RoleEntity;
import com.mitin.aircompany.principal.RolePrincipal;

import java.util.Set;
import java.util.stream.Collectors;

class RolePrincipleConverter {

    private static RolePrincipal convertToPrincipal(RoleEntity roleEntity){
        return new RolePrincipal(roleEntity);
    }

    static Set<RolePrincipal> convertToPrincipal(Set<RoleEntity> roleEntities){
        return roleEntities.stream()
                .map(RolePrincipleConverter::convertToPrincipal)
                .collect(Collectors.toSet());
    }
}
