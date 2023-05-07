package org.daofab.test.controller;

import org.daofab.test.dto.TransactionDTO;
import org.daofab.test.dto.TransactionPageDTO;
import org.daofab.test.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public TransactionPageDTO getTransactionsWithTotalPaidAmount(@RequestParam(name = "page", defaultValue = "0") int pageNumber) {
        return transactionService.getTransactionsWithTotalPaidAmount(pageNumber);
    }

    @GetMapping("/{transactionId}")
    public TransactionDTO getTransactionById(@PathVariable Long transactionId) {
        return transactionService.getById(transactionId);
    }

}
