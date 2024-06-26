package com.example.ebank.Repository;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepoisitory extends JpaRepository <Demande,Long> {
    @Query("SELECT d FROM Demande d WHERE d.client.id = :id")
    Optional<List<Demande>> findByIdClient(@Param("id") long id);

}
