package com.example.ebank.Repository;

import com.example.ebank.Entity.Controlle;
import com.example.ebank.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IControlleRepo  extends JpaRepository<Controlle,Long> {
}
