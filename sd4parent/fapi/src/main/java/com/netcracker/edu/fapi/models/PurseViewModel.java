package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurseViewModel {

    private long id;
    @CreditCardNumber
    @NotBlank
    private String number;
    private String balance;
    @NotBlank
    private long idAcc;

    public PurseViewModel() {
    }

    public PurseViewModel(long id, @CreditCardNumber @NotBlank String number, String balance, @NotBlank long idAcc) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.idAcc = idAcc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public long getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(long idAcc) {
        this.idAcc = idAcc;
    }
}
