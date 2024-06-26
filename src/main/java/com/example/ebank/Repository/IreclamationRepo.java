package com.example.ebank.Repository;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IreclamationRepo extends JpaRepository<Reclamation,Long> {
    @Query("SELECT r FROM Reclamation r WHERE r.client.id = :id")
    Optional<List<Reclamation>> findByIdClient(@Param("id") long id);

}
