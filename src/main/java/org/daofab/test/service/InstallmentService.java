package org.daofab.test.service;

import org.daofab.test.dto.InstallmentDTO;
import org.daofab.test.entity.Installment;

import java.util.List;

public interface InstallmentService {


    public List<InstallmentDTO> getAllInstallmentsByTransaction(Long transactionId);


    public void insert(List<Installment> installments);

}
