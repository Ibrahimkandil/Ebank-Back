package com.example.ebank.Controllers;

import com.example.ebank.Services.ICompte_BancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Comptes")
public class Compte_BancaireController {
    private final ICompte_BancaireService Compte_BancaireService;

    @Autowired
    public Compte_BancaireController(ICompte_BancaireService Compte_BancaireService) {
        this.Compte_BancaireService = Compte_BancaireService;
    }
}
