package com.example.ebank.Services;

import com.example.ebank.Entity.Compte_Bancaire;
import java.util.List;

public interface ICompte_BancaireService {
    Compte_Bancaire addCompte(Compte_Bancaire compte);
    Compte_Bancaire getCompte(Long id);
    List<Compte_Bancaire> getAllComptes();
    Compte_Bancaire updateCompte(Long id, Compte_Bancaire newCompte);
    void deleteCompte(Long id);
}
