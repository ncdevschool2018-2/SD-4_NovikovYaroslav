package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purse")
public class Purse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purse")
    private long id;
    @Column(name = "number")
    private String number;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "id_account")
    private long idAcc;

    public Purse() {
    }

    public Purse(String number, Integer balance, long idAcc) {
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public long getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(long idAcc) {
        this.idAcc = idAcc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purse purse = (Purse) o;
        return id == purse.id &&
                Objects.equals(number, purse.number) &&
                Objects.equals(balance, purse.balance) &&
                Objects.equals(idAcc, purse.idAcc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, balance, idAcc);
    }

    @Override
    public String toString() {
        return "Purse{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance='" + balance + '\'' +
                ", idAcc='" + idAcc + '\'' +
                '}';
    }
}
