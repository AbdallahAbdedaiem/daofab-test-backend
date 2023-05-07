package org.daofab.test.service.impl;

import org.daofab.test.dto.InstallmentDTO;
import org.daofab.test.entity.Installment;
import org.daofab.test.repository.InstallmentRepository;
import org.daofab.test.service.InstallmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallmentServiceImpl implements InstallmentService {
    private final InstallmentRepository installmentRepository;

    public InstallmentServiceImpl(InstallmentRepository installmentRepository) {
        this.installmentRepository = installmentRepository;
    }

    @Override
    public List<InstallmentDTO> getAllInstallmentsByTransaction(Long transactionId) {
        return installmentRepository.findInstallmentDtoByTransactionId(transactionId);
    }

    @Override
    public void insert(List<Installment> installments) {
        installmentRepository.saveAll(installments);
    }
}
