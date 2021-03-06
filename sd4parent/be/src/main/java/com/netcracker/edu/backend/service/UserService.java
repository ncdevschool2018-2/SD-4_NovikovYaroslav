package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Iterable<User> getAllUsers();
    void deleteUser(Long id);
    Optional<User> findByLogin(String login);
    Optional<User> getUserByLogin(String login);
}
