package com.example.ebank.Services;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Repository.DemandeRepoisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DemandeService implements IdemandeService{
    @Autowired
    private DemandeRepoisitory demandeRepoisitory;
    @Override
    public List<Demande> getAlldemandes() {
        return  demandeRepoisitory.findAll();
    }

    @Override
    public Optional<Demande> getdemandeById(Long id) {
        return demandeRepoisitory.findById(id);
    }

    @Override
    public Demande createdemande(Demande demande) {
        return demandeRepoisitory.save(demande);
    }

    @Override
    public Demande updatedemande(Long id, Demande newdemandeData) {
        Optional<Demande> optionalDemande = demandeRepoisitory.findById(id);
        if (optionalDemande.isPresent()) {
            Demande existingDemande = optionalDemande.get();

            existingDemande.setClient(newdemandeData.getClient());
            existingDemande.setType(newdemandeData.getType());
            existingDemande.setMontant(newdemandeData.getMontant());
            existingDemande.setType(newdemandeData.getType());
            existingDemande.setRaisonDemandeCredit(newdemandeData.getRaisonDemandeCredit());

            return demandeRepoisitory.save(existingDemande);
        } else {
            return null;
        }    }


    @Override
    public void deletedemande(Long id) {
        demandeRepoisitory.deleteById(id);

    }

 }