package com.example.ebank.Repository;
import com.example.ebank.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification AND c.Password = :password")
     Optional<Client> findByIdentificationAndPassword(@Param("identification") String identification, @Param("password") String password);
    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification ")

     Client findByIdentificationNumber(@Param("identification") String id);
    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification ")

    Optional<Client> findByIdentificationnumber(@Param("identification") String id);
    @Query("SELECT c FROM Client c WHERE c.Email = :email ")

Optional<Client> findByEmail(@Param("email") String email);

    @Query("SELECT CONCAT(c.first_name, ' ', c.last_name) AS username FROM Client c WHERE c.Email = :email")
    Optional<String> getUserNameByEmail(@Param("email") String email);
//    Optional<Client> findByIdentificationNumber(String id);
    @Query("SELECT COUNT(c), c.addedBy.id FROM Client c GROUP BY c.addedBy.id")
    Optional<List<Object[]>> countClientsByEmployee();

}

