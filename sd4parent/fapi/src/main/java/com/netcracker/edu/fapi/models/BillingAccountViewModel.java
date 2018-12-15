package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountViewModel {

    private int id;
    private String name;
    private String surname;
    private String email;
    private Object user;
    private Object purse;
    private List<Object> accountProducts;

    public BillingAccountViewModel() {
    }

    public BillingAccountViewModel(int id, String name, String surname, String email, Object user, Object purse, List<Object> accountProducts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.user = user;
        this.purse = purse;
        this.accountProducts = accountProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getPurse() {
        return purse;
    }

    public void setPurse(Object purse) {
        this.purse = purse;
    }

    public List<Object> getAccountProducts() {
        return accountProducts;
    }

    public void setAccountProducts(List<Object> accountProducts) {
        this.accountProducts = accountProducts;
    }
}
