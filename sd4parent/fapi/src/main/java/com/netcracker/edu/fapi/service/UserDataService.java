package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserViewModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDataService {
    List<UserViewModel> getAll();
    Optional getUserById(Long id);
    UserViewModel saveUser(UserViewModel user);
    void deleteUser(Long id);
    UserViewModel findByLogin(String name);
    UserDetails loadUserByUsername(String name);
    UserViewModel getAccountByLogin(String login);
    UserViewModel getUserByLogin(String login);
    UserViewModel getAccountById(Integer id);
}
