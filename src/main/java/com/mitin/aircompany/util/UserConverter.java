package com.mitin.aircompany.util;

import com.mitin.aircompany.entity.RoleEntity;
import com.mitin.aircompany.entity.UserEntity;
import com.mitin.aircompany.model.Role;
import com.mitin.aircompany.model.User;
import com.mitin.aircompany.principal.RolePrincipal;
import com.mitin.aircompany.principal.UserPrincipal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserPrincipal convertToPrincipal(UserEntity userEntity){
        Set<RolePrincipal> roles = userEntity.getRoles()
                .stream()
                .map(role -> RolePrincipal.valueOf(role.toString()))
                .collect(Collectors.toSet());

        return new UserPrincipal(
                userEntity.getId(), userEntity.getUsername(),
                userEntity.getPassword(), roles);
    }

    public static UserEntity convertToEntity(User user){
        Set<RoleEntity> roles = user.getRoles()
                .stream()
                .map(role -> RoleEntity.valueOf(role.toString()))
                .collect(Collectors.toSet());
        return new UserEntity(user.getUsername(), user.getPassword(), user.getEmail(), roles);
    }

    public static User convertToModel(UserEntity userEntity){
        Set<Role> roles = userEntity.getRoles()
                .stream()
                .map(roleEntity -> Role.valueOf(roleEntity.toString()))
                .collect(Collectors.toSet());
        return new User(
                userEntity.getId(), userEntity.getUsername(),
                userEntity.getPassword(), userEntity.getEmail(), roles
        );
    }

    public static List<User> convertToModel(List<UserEntity> userEntities){
        return userEntities
                .stream()
                .map(UserConverter::convertToModel)
                .collect(Collectors.toList());
    }
}
