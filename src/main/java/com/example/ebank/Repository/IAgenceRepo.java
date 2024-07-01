package com.example.ebank.Repository;

import com.example.ebank.Entity.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgenceRepo extends JpaRepository<Agence,Long> {
}
