package com.mitin.aircompany.controller;

import com.mitin.aircompany.model.User;
import com.mitin.aircompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/sign-up")
    public void signUp(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public void findAll(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        userService.findAll(pageable);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{userId}")
    public User findById(
            @PathVariable("userId") Long userId
    ){
        return userService.findById(userId);
    }
}
