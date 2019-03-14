package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.UserEntity;
import com.mitin.aircompany.principal.RolePrincipal;
import com.mitin.aircompany.principal.UserPrincipal;

import java.util.Set;
import java.util.stream.Collectors;

public class UserPrincipalConverter {

    public static UserPrincipal convertToPrincipal(UserEntity userEntity){
        Set<RolePrincipal> roles = userEntity.getRoles()
                .stream()
                .map(role -> RolePrincipal.valueOf(role.toString()))
                .collect(Collectors.toSet());

        return new UserPrincipal(
                userEntity.getId(), userEntity.getUsername(),
                userEntity.getPassword(), roles);
    }
}
