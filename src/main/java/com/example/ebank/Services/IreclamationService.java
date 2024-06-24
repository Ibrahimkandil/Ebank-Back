package com.example.ebank.Services;

import com.example.ebank.Entity.Reclamation;

import java.util.List;

public interface IreclamationService  {
    List<Reclamation> retrieveAllReclamations();
    Reclamation addReclamation(Reclamation reclamation);
    Reclamation updateReclamation(Long id, Reclamation reclamation);
    Reclamation retrieveReclamation(Long id);
    String deleteReclamation(Long id);
}
