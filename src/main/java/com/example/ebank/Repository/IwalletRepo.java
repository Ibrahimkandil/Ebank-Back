package com.example.ebank.Repository;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IwalletRepo extends JpaRepository<Wallet,Long> {
    @Query("SELECT w FROM Wallet w WHERE w.client.id = :id ")
    Optional<List<Wallet>> findByClientId(@Param("id") Long id);
}
