package com.mitin.aircompany.service;

import com.mitin.aircompany.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);

    List<User> findAll(Pageable pageable);

    User findById(Long userId);
}
