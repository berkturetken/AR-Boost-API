package com.example.arboostapi.controller;

import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addUser (@RequestParam String name, @RequestParam String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(user);
        return "User is saved successfully :)";
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
