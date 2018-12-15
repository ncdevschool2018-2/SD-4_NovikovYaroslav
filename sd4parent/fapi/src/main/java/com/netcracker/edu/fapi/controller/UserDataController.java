package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/us")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @RequestMapping
    public ResponseEntity<List<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserViewModel> saveUser(@RequestBody UserViewModel user /*todo server validation*/) {
        UserViewModel newUser =
                new UserViewModel(user.getId(),user.getLogin(), bcryptEncoder.encode(user.getPassword()), user.getRole(),user.getAccount());
        if (newUser != null) {
            return ResponseEntity.ok(userDataService.saveUser(newUser));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        userDataService.deleteUser(Long.valueOf(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getUserByLogin(@RequestParam("login") String login) {
        return ResponseEntity.ok(userDataService.getUserByLogin(login));
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getAccountByLoginAndPassword(@RequestParam(name = "login") String login) {
        UserViewModel account = userDataService.getAccountByLogin(login);
        return ResponseEntity.ok(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserViewModel> getAccountById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(userDataService.getAccountById(id));
    }

}
