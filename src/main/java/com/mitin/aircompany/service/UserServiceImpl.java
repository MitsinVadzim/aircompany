package com.mitin.aircompany.service;

import com.mitin.aircompany.entity.UserEntity;
import com.mitin.aircompany.repository.UserRepository;
import com.mitin.aircompany.service.interfaces.UserService;
import com.mitin.aircompany.util.UserPrincipalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return UserPrincipalConverter.convertToPrincipal(userEntity);
    }
}
