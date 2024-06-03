package com.example.ebank.Services;

import com.example.ebank.Repository.ICompte_BancaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Compte_BancaireService implements ICompte_BancaireService{
    private final ICompte_BancaireRepo Compte_BancaireRepo ;

    @Autowired
    public Compte_BancaireService(ICompte_BancaireRepo Compte_BancaireRepo) {
        this.Compte_BancaireRepo = Compte_BancaireRepo;
    }
}
