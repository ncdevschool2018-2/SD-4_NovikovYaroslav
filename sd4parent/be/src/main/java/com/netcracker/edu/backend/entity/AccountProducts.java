package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account_products")
public class AccountProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account_products")
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_account")
    private BillingAccount account;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_product")
    private Product product;
    @Column(name = "date_beg")
    private Date dateBeg;
    @Column(name = "date_end")
    private Date dateEnd;
    @Column(name = "status")
    private boolean status;

    public AccountProducts() {
    }

    public AccountProducts(BillingAccount account, Product product, Date dateBeg, Date dateEnd, boolean status) {
        this.account = account;
        this.product = product;
        this.dateBeg = dateBeg;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BillingAccount getAccount() {
        return account;
    }

    public void setAccount(BillingAccount account) {
        this.account = account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountProducts that = (AccountProducts) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(account, that.account) &&
                Objects.equals(product, that.product) &&
                Objects.equals(dateBeg, that.dateBeg) &&
                Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, product, dateBeg, dateEnd, status);
    }
}
