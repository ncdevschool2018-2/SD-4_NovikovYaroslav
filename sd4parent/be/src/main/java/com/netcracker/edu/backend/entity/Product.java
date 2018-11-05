package com.netcracker.edu.backend.entity;

import org.omg.CORBA.StringHolder;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private String cost;
    @Column(name = "days")
    private String days;
    @Column(name = "description")
    private String description;
    @Column(name = "pictures")
    private String pictures;

    public Product() {

    }

    public Product(String title, String cost, String days, String description, String pictures) {
        this.title = title;
        this.cost = cost;
        this.days = days;
        this.description = description;
        this.pictures = pictures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(title, product.title) &&
                Objects.equals(cost, product.cost) &&
                Objects.equals(days, product.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost, days);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", days=" + days +
                '}';
    }
}
