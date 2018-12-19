package com.netcracker.edu.fapi.models;

public class MoneyOperationViewModel {

    private Long id;
    private Integer amount;

    public MoneyOperationViewModel() {
    }

    public MoneyOperationViewModel(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


}