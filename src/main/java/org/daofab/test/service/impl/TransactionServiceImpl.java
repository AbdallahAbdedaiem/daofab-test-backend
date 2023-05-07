package org.daofab.test.service.impl;

import org.daofab.test.dto.TransactionDTO;
import org.daofab.test.dto.TransactionPageDTO;
import org.daofab.test.entity.Transaction;
import org.daofab.test.projection.TransactionProjection;
import org.daofab.test.repository.TransactionRepository;
import org.daofab.test.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO getById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElseThrow();
        return TransactionDTO.fromTransaction(transaction);
    }

    @Override
    public TransactionPageDTO getTransactionsWithTotalPaidAmount(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 2);
        Page<TransactionProjection> transactionProjectionPage = transactionRepository.getTransactionsWithAmounts(pageRequest);
        return TransactionPageDTO.fromPage(transactionProjectionPage);
    }

    @Override
    public void insert(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
    }
}
