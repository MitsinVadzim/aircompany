package com.mitin.aircompany.service;

import com.mitin.aircompany.entity.UserEntity;
import com.mitin.aircompany.model.Role;
import com.mitin.aircompany.model.User;
import com.mitin.aircompany.repository.UserRepository;
import com.mitin.aircompany.service.interfaces.UserService;
import com.mitin.aircompany.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new com.mitin.aircompany.exception.UsernameNotFoundException(username);
        }
        return UserConverter.convertToPrincipal(userEntity);
    }

    public User save(User user){
        user.setRoles(Collections.singleton(Role.USER));
        return UserConverter.convertToModel(userRepository.save(UserConverter.convertToEntity(user)));
    }
}
