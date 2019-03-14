package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.UserEntity;
import com.mitin.aircompany.principal.UserPrincipal;

public class UserPrincipalConverter {

    public static UserPrincipal convertToPrincipal(UserEntity userEntity){
        return new UserPrincipal(
                userEntity.getId(), userEntity.getUsername(),
                userEntity.getPassword(), RolePrincipleConverter.convertToPrincipal(userEntity.getRoles()));
    }
}
