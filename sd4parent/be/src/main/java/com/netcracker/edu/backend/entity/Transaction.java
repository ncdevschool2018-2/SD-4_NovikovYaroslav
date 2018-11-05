package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private long id;
    @Column(name = "action")
    private String action;
    @Column(name = "cost")
    private String cost;
    @Column(name = "id_purse")
    private long id_purse;

    public Transaction() {
    }

    public Transaction(String action, String cost, long id_purse) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                Objects.equals(action, that.action) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(id_purse, that.id_purse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, cost, id_purse);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", cost='" + cost + '\'' +
                ", id_purse='" + id_purse + '\'' +
                '}';
    }
}
