package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserRepo extends CrudRepository<User, Long> {
    ArrayList<User> findByUsername(String name);
    ArrayList<User> findByFname(String name);
}
