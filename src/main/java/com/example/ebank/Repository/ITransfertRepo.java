package com.example.ebank.Repository;

import com.example.ebank.Entity.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransfertRepo extends JpaRepository<Transfert,Long> {
}
