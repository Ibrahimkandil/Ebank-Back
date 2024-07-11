package com.example.ebank.Repository;

import com.example.ebank.Entity.WalletHistorique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IwalletHistoryRepo extends JpaRepository<WalletHistorique, Long>    {
}
