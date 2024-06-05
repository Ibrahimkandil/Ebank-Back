package com.example.ebank.Services;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Repository.ICompte_BancaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Compte_BancaireService implements ICompte_BancaireService{
    private final ICompte_BancaireRepo Compte_BancaireRepo ;

    @Autowired
    public Compte_BancaireService(ICompte_BancaireRepo Compte_BancaireRepo) {
        this.Compte_BancaireRepo = Compte_BancaireRepo;
    }

    @Override
    public Compte_Bancaire addCompte(Compte_Bancaire compte){
        return Compte_BancaireRepo.save(compte);
    }

    @Override
    public Compte_Bancaire getCompte(Long id) {
        Optional<Compte_Bancaire> compte = Compte_BancaireRepo.findById(id);
        if (compte.isPresent()) {
            return compte.get();
        }
        return null;
    }

    @Override
    public List<Compte_Bancaire> getAllComptes(){
        return Compte_BancaireRepo.findAll();
    }

    @Override
    public Compte_Bancaire updateCompte(Long id, Compte_Bancaire newCompte) {
        Optional<Compte_Bancaire> oldCompte = Compte_BancaireRepo.findById(id);
        if (oldCompte.isPresent()) {
            Compte_Bancaire compte = oldCompte.get();

            compte.setBalance(newCompte.getBalance());
            compte.setClosing_date(newCompte.getClosing_date());
            compte.setInterest_rate(newCompte.getInterest_rate());
            compte.setDate_d_ajout(newCompte.getDate_d_ajout());
            return Compte_BancaireRepo.save(compte);
        }
        return null;
    }
    @Override
    public void deleteCompte(Long id){
        Optional<Compte_Bancaire> compte = Compte_BancaireRepo.findById(id);
        if (compte.isPresent()) {
            Compte_BancaireRepo.deleteById(id);
        }
    }
}
