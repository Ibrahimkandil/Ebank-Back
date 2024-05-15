package com.example.ebank.Repository;

import com.example.ebank.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IwalletRepo extends JpaRepository<Wallet,Long> {
}
