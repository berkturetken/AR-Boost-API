package com.example.arboostapi.repository;

import com.example.arboostapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
