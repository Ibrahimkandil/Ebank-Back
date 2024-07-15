package com.example.ebank.Repository;

import com.example.ebank.Entity.Controlle;
import com.example.ebank.Entity.EtatCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface IControlleRepo  extends JpaRepository<Controlle,Long> {
    @Query("SELECT c FROM Controlle c WHERE c.id_User= :id_User and c.type= :type")
    Optional<Controlle> getControlleByUserIdANDType(@Param("id_User") Long id_User, @Param("type") String type);

    @Query("SELECT c FROM Controlle c WHERE c.etatCompte= :type ")
    Optional<List<Controlle>> getControlleByType(@Param("type") EtatCompte type_controlle);

}
