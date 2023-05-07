package org.daofab.test.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "installments")
public class Installment {
    @Id
    private Long id;
    private BigDecimal paidAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Transaction transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
