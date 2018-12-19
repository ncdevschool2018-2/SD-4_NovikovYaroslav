package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductViewModel {

    private int id;
    @NotBlank
    @Size(min = 2, max = 20)
    private String title;
    @NotBlank
    private String cost;
    @NotBlank
    private String days;
    @NotBlank
    private String description;
    @NotBlank
    private String pictures;

    public ProductViewModel(){

    }

    public ProductViewModel(int id, @NotBlank @Size(min = 2, max = 20) String title, @NotBlank String cost,
                            @NotBlank String days, @NotBlank String description, @NotBlank String pictures) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.days = days;
        this.description = description;
        this.pictures = pictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
