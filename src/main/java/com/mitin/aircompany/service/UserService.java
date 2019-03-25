package com.mitin.aircompany.service;

import com.mitin.aircompany.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll(Pageable pageable);

    User findById(Long userId);
}
