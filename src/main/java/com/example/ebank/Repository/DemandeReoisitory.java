package com.example.ebank.Repository;

import com.example.ebank.Entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeReoisitory  extends JpaRepository <Demande,Long> {

}
