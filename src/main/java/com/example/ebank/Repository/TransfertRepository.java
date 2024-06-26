package com.example.ebank.Repository;

import com.example.ebank.Entity.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert, Long> {
    @Query("SELECT t FROM Transfert t WHERE t.idCompteDestinations.id = :id OR t.idCompteSource.id = :id")
    Optional<List<Transfert>> findByIdClient(@Param("id") long id);
}
