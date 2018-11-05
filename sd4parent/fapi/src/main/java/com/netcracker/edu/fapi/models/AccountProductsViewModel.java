package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountProductsViewModel {

    private long idAcc;
    private long idPr;
    private Date dateBeg;
    private Date dateEnd;

    public AccountProductsViewModel() {
    }

    public AccountProductsViewModel(long idAcc, long idPr, Date dateBeg, Date dateEnd) {
        this.idAcc = idAcc;
        this.idPr = idPr;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
    }

    public long getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(long idAcc) {
        this.idAcc = idAcc;
    }

    public long getIdPr() {
        return idPr;
    }

    public void setIdPr(long idPr) {
        this.idPr = idPr;
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
