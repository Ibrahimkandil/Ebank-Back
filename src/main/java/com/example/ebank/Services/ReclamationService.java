package com.example.ebank.Services;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Repository.IreclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService implements IreclamationService {

    @Autowired
    IreclamationRepo ireclamationRepo ;
    @Override
    public List<Reclamation> retrieveAllReclamations() {
        return ireclamationRepo.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return ireclamationRepo.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return null;
    }

    @Override
    public Reclamation retrieveReclamation(Long id) {
        return ireclamationRepo.findById(id).get();
    }

    @Override
    public String deleteReclamation(Long id) {
        ireclamationRepo.deleteById(id);
        return "Réclamation supprimée ";
    }
}
