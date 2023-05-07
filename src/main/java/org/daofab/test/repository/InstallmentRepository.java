package org.daofab.test.repository;

import org.daofab.test.dto.InstallmentDTO;
import org.daofab.test.entity.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {
    @Query("SELECT new org.daofab.test.dto.InstallmentDTO(ins.id, ins.paidAmount) FROM Installment ins WHERE ins.transaction.id = :transactionId")
    List<InstallmentDTO> findInstallmentDtoByTransactionId(@Param("transactionId") Long transactionId);
}
