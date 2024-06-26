package com.example.ebank.Repository;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Entity.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.client.id = :id")
    Optional<List<Transaction>> findByIdClient(@Param("id") long id);
}
