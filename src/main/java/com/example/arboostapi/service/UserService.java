package com.example.arboostapi.service;

import com.example.arboostapi.model.User;

public interface UserService {

    String addUser(String name, String surname);

    Iterable<User> getAllUsers();
}
