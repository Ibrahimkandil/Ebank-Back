package com.example.ebank.Services;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.contrat_prete;
import com.example.ebank.Repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService implements IContratService{

    @Autowired
    private ContratRepository contratRepository;
    @Override
    public List<contrat_prete> getAllcontrats() {
        return contratRepository.findAll();
    }

    @Override
    public Optional<contrat_prete> getcontratById(Long id) {
        return  contratRepository.findById(id);
    }

    @Override
    public contrat_prete createcontrat_prete(contrat_prete contrat_prete) {
        return contratRepository.save(contrat_prete);
    }

    @Override
    public contrat_prete updatecontrat_prete(Long id, contrat_prete newcontrat_prete) {
        Optional<contrat_prete> optionalcontratRepository = contratRepository.findById(id);
        if (optionalcontratRepository.isPresent()) {
            contrat_prete existingcontrat_prete = optionalcontratRepository.get();

            existingcontrat_prete.setClient(newcontrat_prete.getClient());
            existingcontrat_prete.setDuree(newcontrat_prete.getDuree());
            existingcontrat_prete.setMontant(newcontrat_prete.getMontant());
            existingcontrat_prete.setEtatContrat(newcontrat_prete.getEtatContrat());
            existingcontrat_prete.setDescription(newcontrat_prete.getDescription());

            existingcontrat_prete.setDate_debut(newcontrat_prete.getDate_debut());

            existingcontrat_prete.setDate_fin(newcontrat_prete.getDate_fin());

            existingcontrat_prete.setFraisDossier(newcontrat_prete.getFraisDossier());

            existingcontrat_prete.setFrequencePaiement(newcontrat_prete.getFrequencePaiement());

            existingcontrat_prete.setInformationsAssurance(newcontrat_prete.getInformationsAssurance());

            existingcontrat_prete.setDemande(newcontrat_prete.getDemande());

            existingcontrat_prete.setTypeInteret(newcontrat_prete.getTypeInteret());
            existingcontrat_prete.setMensualites(newcontrat_prete.getMensualites());

            return contratRepository.save(existingcontrat_prete);
        } else {
            return null;
        }    }

    @Override
    public void deletecontrat_prete(Long id) {
        contratRepository.deleteById(id);

    }
}
