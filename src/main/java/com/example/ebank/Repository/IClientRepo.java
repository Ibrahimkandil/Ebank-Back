package com.example.ebank.Repository;
import com.example.ebank.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification AND c.Password = :password")
     Client findByIdentificationAndPassword(@Param("identification") String identification, @Param("password") String password);
    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification ")

     Client findByIdentificationNumber(@Param("identification") String id);
    @Query("SELECT c FROM Client c WHERE c.IdentificationNumber = :identification ")

    Optional<Client> findByIdentificationnumber(@Param("identification") String id);
    @Query("SELECT c FROM Client c WHERE c.Email = :email ")

Optional<Client> findByEmail(@Param("email") String email);


//    Optional<Client> findByIdentificationNumber(String id);

}

