package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {

    private int id;
    @NotBlank
    @Size(min = 4, max = 30)
    private String login;
    @NotBlank
    @Size(min = 6)
    private String password;
    @NotBlank
    private String role;
    private Object account;

    public UserViewModel() {
    }

    public UserViewModel(int id, @NotBlank @Size(min = 4, max = 30) String login, @NotBlank @Size(min = 6) String password,
                         @NotBlank String role, Object account) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }
}
