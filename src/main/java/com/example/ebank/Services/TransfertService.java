package com.example.ebank.Services;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Repository.ICompte_BancaireRepo;
import com.example.ebank.Repository.ITransfertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransfertService implements ITransfertService{

    private final ITransfertRepo TransfertRepo ;
    private final ICompte_BancaireRepo Compte_BancaireRepo;

    @Autowired
    public TransfertService(ITransfertRepo TransfertRepo, ICompte_BancaireRepo Compte_BancaireRepo) {
        this.TransfertRepo = TransfertRepo;
        this.Compte_BancaireRepo = Compte_BancaireRepo;
    }

    @Override
    public Transfert addTransfert(Transfert transfert) {
        Optional<Compte_Bancaire> oldFirstCompte = Compte_BancaireRepo.findById(transfert.getIdCompteSource().getId());
        Optional<Compte_Bancaire> oldSecondCompte = Compte_BancaireRepo.findById(transfert.getIdCompteDestinations().getId());
        if (oldFirstCompte.isPresent()) {
            if(oldSecondCompte.isPresent()){
                Compte_Bancaire newFirstCompte = oldFirstCompte.get();
                Compte_Bancaire newSecondcompte = oldSecondCompte.get();
                newFirstCompte.setBalance(oldFirstCompte.get().getBalance() - transfert.getAmount());
                newSecondcompte.setBalance(oldSecondCompte.get().getBalance() + transfert.getAmount());
                Compte_BancaireRepo.save(newFirstCompte);
                Compte_BancaireRepo.save(newSecondcompte);
            }
        }
        return TransfertRepo.save(transfert);
    }

    @Override
    public Transfert getTransfert(Long id) {
        Optional<Transfert> transfert = TransfertRepo.findById(id);
        if (transfert.isPresent()) {
            return transfert.get();
        }
        return null;
    }

    @Override
    public List<Transfert> getAllTransferts() {
        return TransfertRepo.findAll();
    }

    @Override
    public List<Transfert> getAllTranfertsByCompte(Long id) {
        List<Transfert> AllTranferts = getAllTransferts();
        List<Transfert> TransfertsByUser = new ArrayList<>();

        for (Transfert transfert : AllTranferts) {
            if (transfert.getIdCompteSource().getId().equals(id)) {
                TransfertsByUser.add(transfert);
            }
        }
        return TransfertsByUser;
    }

}
