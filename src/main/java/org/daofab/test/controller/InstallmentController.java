package org.daofab.test.controller;


import org.daofab.test.dto.InstallmentDTO;
import org.daofab.test.service.InstallmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/installments")
public class InstallmentController {
    private final InstallmentService installmentService;

    public InstallmentController(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @GetMapping("/transaction/{transactionId}")
    public List<InstallmentDTO> getAllInstallmentsByTransaction(@PathVariable Long transactionId ) {
        return installmentService.getAllInstallmentsByTransaction(transactionId);
    }
}
