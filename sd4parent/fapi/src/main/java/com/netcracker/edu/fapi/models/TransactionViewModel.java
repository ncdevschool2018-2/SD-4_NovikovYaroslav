package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionViewModel {

    private long id;
    private String action;
    private String cost;
    private long id_purse;

    public TransactionViewModel() {
    }

    public TransactionViewModel(long id, String action, String cost, long id_purse) {
        this.id = id;
        this.action = action;
        this.cost = cost;
        this.id_purse = id_purse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public long getId_purse() {
        return id_purse;
    }

    public void setId_purse(long id_purse) {
        this.id_purse = id_purse;
    }
}
