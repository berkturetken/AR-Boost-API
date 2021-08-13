package com.example.arboostapi.service;

import com.example.arboostapi.model.User;
import com.example.arboostapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public String addUser(String name, String surname) {
        try {
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            userRepository.save(user);
            return "User is saved successfully :)";
        } catch (Exception e) {
            return "Error occurred while saving user." + e.toString();
        }
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
