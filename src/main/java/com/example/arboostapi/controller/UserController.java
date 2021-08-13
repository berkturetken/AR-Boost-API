package com.example.arboostapi.controller;

import com.example.arboostapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String surname) {
        try {
            userService.addUser(name, surname);
            return new ResponseEntity<>(
                    "User is saved successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while saving user.",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<String> getAllUsers() {
        try {
            userService.getAllUsers();
            return new ResponseEntity<>(
                    "Users are returned successfully :)",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error occurred while returning users.",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
