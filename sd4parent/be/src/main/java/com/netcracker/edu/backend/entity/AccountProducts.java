package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account_products")
public class AccountProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private long idAcc;
    @Column(name = "id_product")
    private long idPr;
    @Column(name = "date_beg")
    private Date dateBeg;
    @Column(name = "date_end")
    private Date dateEnd;

    public AccountProducts() {
    }

    public AccountProducts(long idPr, Date dateBeg, Date dateEnd) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountProducts that = (AccountProducts) o;
        return idAcc == that.idAcc &&
                idPr == that.idPr &&
                Objects.equals(dateBeg, that.dateBeg) &&
                Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAcc, idPr, dateBeg, dateEnd);
    }

    @Override
    public String toString() {
        return "AccountProducts{" +
                "idAcc=" + idAcc +
                ", idPr=" + idPr +
                ", dateBeg=" + dateBeg +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
