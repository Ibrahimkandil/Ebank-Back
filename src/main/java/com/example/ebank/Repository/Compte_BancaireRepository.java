package com.example.ebank.Repository;

import com.example.ebank.Entity.Compte_Bancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Compte_BancaireRepository extends JpaRepository<Compte_Bancaire, Long> {
    @Query("SELECT c FROM Compte_Bancaire c WHERE c.client.id = :identification ")
    Optional<List<Compte_Bancaire>> findByIdClient(@Param("identification") Long id);
}
