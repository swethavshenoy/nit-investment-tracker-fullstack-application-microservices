package com.natwest.controller;


import com.natwest.Repository.UserRepository;
import com.natwest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userrepository;

    @GetMapping("/")
    public List<User> getAllUser() {
        return userrepository.findAll();
    }
}

