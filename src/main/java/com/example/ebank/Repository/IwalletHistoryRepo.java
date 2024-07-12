package com.example.ebank.Repository;

import com.example.ebank.Entity.WalletHistorique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IwalletHistoryRepo extends JpaRepository<WalletHistorique, Long>    {

            @Query("SELECT w FROM WalletHistorique w WHERE w.Compte_Bancaire_Id = :id_compte ")
            Optional<List<WalletHistorique>> getAllWalletsByCompte_Bancaire_Id(@Param("id_compte") Long id_compte);
}
