package org.daofab.test.repository;

import org.daofab.test.entity.Installment;
import org.daofab.test.entity.Transaction;
import org.daofab.test.projection.TransactionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT tr.id, tr.receiver, tr.sender, tr.total_amount AS totalAmount, SUM(ins.paid_amount) AS totalPaidAmount\n" +
            "FROM transactions tr\n" +
            "LEFT JOIN installments ins ON tr.id = ins.transaction_id\n" +
            "GROUP BY tr.id", nativeQuery = true)
    Page<TransactionProjection> getTransactionsWithAmounts(Pageable pageable);
}
