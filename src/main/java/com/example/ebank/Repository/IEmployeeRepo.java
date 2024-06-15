package com.example.ebank.Repository;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.IdentificationNumber = :identification AND e.password = :password")
    public Client findByIdentificationAndPassword(@Param("identification") String identification, @Param("password") String password);
    @Query("SELECT e FROM Employee e WHERE e.IdentificationNumber = :identification")

    public Optional<Employee> findByIdentificationNumber(@Param("identification") String id);


}
