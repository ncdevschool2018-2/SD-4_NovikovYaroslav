package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_features")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private String cost;
    @Column(name = "days")
    private String days;
    @Column(name = "id_product")
    private long idPr;

    public Feature(String title, String cost, String days, long idPr) {
        this.title = title;
        this.cost = cost;
        this.days = days;
        this.idPr = idPr;
    }

    public Feature() {
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

    public long getIdPr() {
        return idPr;
    }

    public void setIdPr(long idPr) {
        this.idPr = idPr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return id == feature.id &&
                idPr == feature.idPr &&
                Objects.equals(title, feature.title) &&
                Objects.equals(cost, feature.cost) &&
                Objects.equals(days, feature.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost, days, idPr);
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                ", days='" + days + '\'' +
                ", idPr=" + idPr +
                '}';
    }
}
