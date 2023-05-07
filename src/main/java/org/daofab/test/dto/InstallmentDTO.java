package org.daofab.test.dto;


import java.math.BigDecimal;

public class InstallmentDTO {
    private Long id;
    private BigDecimal paidAmount;

    public InstallmentDTO(Long id, BigDecimal paidAmount) {
        this.id = id;
        this.paidAmount = paidAmount;
    }

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

}
