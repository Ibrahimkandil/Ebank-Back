package com.example.ebank.Repository;

import com.example.ebank.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IreclamationRepo extends JpaRepository<Reclamation,Long> {
}
