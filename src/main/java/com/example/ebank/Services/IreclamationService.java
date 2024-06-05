package com.example.ebank.Services;

import com.example.ebank.Entity.Reclamation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IreclamationService  {

    public List<Reclamation> retrieveAllReclamations();
    public Reclamation addReclamation(Reclamation reclamation);
    public Reclamation updateReclamation (Reclamation reclamation);
    public Reclamation retrieveReclamation (Long id);
    public String deleteReclamation (Long id);
}
