package com.example.ebank.Repository;

import com.example.ebank.Entity.Controlle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IControlleRepo  extends JpaRepository<Controlle,Long> {
    @Query("SELECT c FROM Controlle c WHERE c.id_User= :id_client and c.type= :type")
    Optional<Controlle> getControlleByClientIdANDType(@Param("id_client") Long id_client, @Param("type") String type);


}
