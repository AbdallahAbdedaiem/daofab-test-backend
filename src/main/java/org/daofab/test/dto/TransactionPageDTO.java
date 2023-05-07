package org.daofab.test.dto;

import org.daofab.test.projection.TransactionProjection;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class TransactionPageDTO {
    private List<TransactionProjection> transactions = new ArrayList<>();
    private Integer totalCount;

    public List<TransactionProjection> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionProjection> transactions) {
        this.transactions = transactions;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer total) {
        this.totalCount = total;
    }

    public static TransactionPageDTO fromPage(Page<TransactionProjection> transactionProjectionPage) {
        TransactionPageDTO transactionPageDTO = new TransactionPageDTO();
        transactionPageDTO.setTotalCount((int) transactionProjectionPage.getTotalElements());
        transactionPageDTO.setTransactions(transactionProjectionPage.getContent());
        return transactionPageDTO;
    }
}
