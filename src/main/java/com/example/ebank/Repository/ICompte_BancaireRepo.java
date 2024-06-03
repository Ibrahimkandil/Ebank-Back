package com.example.ebank.Repository;

import com.example.ebank.Entity.Compte_Bancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompte_BancaireRepo extends JpaRepository<Compte_Bancaire,Long> {
}
