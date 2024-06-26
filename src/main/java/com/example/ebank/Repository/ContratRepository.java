package com.example.ebank.Repository;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.contrat_prete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContratRepository extends JpaRepository<contrat_prete,Long> {
    @Query("SELECT cp FROM contrat_prete cp WHERE cp.client.id = :id")
    Optional<List<contrat_prete>> findByIdClient(@Param("id") long id);

}
