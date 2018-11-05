package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureViewModel {

    private long id;
    private String title;
    private String cost;
    private String days;
    private long idPr;

    public FeatureViewModel() {
    }

    public FeatureViewModel(long id, String title, String cost, String days, long idPr) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.days = days;
        this.idPr = idPr;
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
}
