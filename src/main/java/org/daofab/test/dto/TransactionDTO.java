package org.daofab.test.dto;

import org.daofab.test.entity.Transaction;

import java.math.BigDecimal;

public class TransactionDTO {
    private Long id;
    private String sender;
    private String receiver;
    private BigDecimal totalAmount;

    public static TransactionDTO fromTransaction(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setSender(transaction.getSender());
        transactionDTO.setReceiver(transaction.getReceiver());
        transactionDTO.setTotalAmount(transaction.getTotalAmount());
        return transactionDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
