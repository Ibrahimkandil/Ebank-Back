package com.example.ebank.Repository;

import com.example.ebank.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.IdentificationNumber = :identification AND a.password = :password")
         Admin findByIdentificationAndPassword(@Param("identification") String identification, @Param("password") String password);
    @Query("SELECT a FROM Admin a WHERE a.IdentificationNumber = :identification ")

     Optional<Admin> findByIdentificationNumber(@Param("identification") String id);

}
