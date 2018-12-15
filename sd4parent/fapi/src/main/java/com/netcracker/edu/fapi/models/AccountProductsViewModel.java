package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountProductsViewModel {

    private Long id;
    private Object account;
    private Object product;
    private Date dateBeg;
    private Date dateEnd;
    private boolean status;

    public AccountProductsViewModel() {
    }

    public AccountProductsViewModel(Long id, Object account, Object product, Date dateBeg, Date dateEnd, boolean status) {
        this.id = id;
        this.account = account;
        this.product = product;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Date dateBeg) {
        this.dateBeg = dateBeg;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
