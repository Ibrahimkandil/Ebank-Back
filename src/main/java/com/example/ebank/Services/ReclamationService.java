package com.example.ebank.Services;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Repository.IreclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService implements IreclamationService {

    @Autowired
    private IreclamationRepo ireclamationRepo;

    @Override
    public List<Reclamation> retrieveAllReclamations() {
        return ireclamationRepo.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return ireclamationRepo.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Long id, Reclamation newReclamationData) {
        Optional<Reclamation> optionalReclamation = ireclamationRepo.findById(id);
        if (optionalReclamation.isPresent()) {
            Reclamation existingReclamation = optionalReclamation.get();
            // Update existingReclamation with data from newReclamationData
            existingReclamation.setComplainantName(newReclamationData.getComplainantName());
            existingReclamation.setSubject(newReclamationData.getSubject());
            existingReclamation.setDescription(newReclamationData.getDescription());
            existingReclamation.setDate(newReclamationData.getDate());
            existingReclamation.setEmail(newReclamationData.getEmail());
            existingReclamation.setPhoneNumber(newReclamationData.getPhoneNumber());
            return ireclamationRepo.save(existingReclamation);
        } else {
            // Handle case where reclamation with given id is not found
            return null;
        }
    }

    @Override
    public Reclamation retrieveReclamation(Long id) {
        return ireclamationRepo.findById(id).orElse(null);  // or throw an exception
    }

    @Override
    public String deleteReclamation(Long id) {
        Optional<Reclamation> existingReclamation = ireclamationRepo.findById(id);
        if (existingReclamation.isPresent()) {
            ireclamationRepo.deleteById(id);
            return "Réclamation supprimée";
        } else {
            return "Réclamation non trouvée";
        }
    }
}
