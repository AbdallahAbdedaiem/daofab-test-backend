package org.daofab.test.service;

import org.daofab.test.dto.TransactionDTO;
import org.daofab.test.dto.TransactionPageDTO;
import org.daofab.test.entity.Transaction;

import java.util.List;

public interface TransactionService {

    public TransactionDTO getById(Long transactionId);

    public TransactionPageDTO getTransactionsWithTotalPaidAmount(int page);

    public void insert(List<Transaction> transactions);


}
