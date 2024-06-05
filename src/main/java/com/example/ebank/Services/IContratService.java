package com.example.ebank.Services;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.contrat_prete;

import java.util.List;
import java.util.Optional;

public interface IContratService {
    List<contrat_prete> getAllcontrats();
    Optional<contrat_prete> getcontratById(Long id);
    contrat_prete createcontrat_prete(contrat_prete contrat_prete);
    contrat_prete updatecontrat_prete(Long id, contrat_prete newcontrat_prete);
    void deletecontrat_prete(Long id);


}
