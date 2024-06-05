package com.example.ebank.Controllers;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Services.ICompte_BancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Comptes")
public class Compte_BancaireController {
    private final ICompte_BancaireService Compte_BancaireService;

    @Autowired
    public Compte_BancaireController(ICompte_BancaireService Compte_BancaireService) {
        this.Compte_BancaireService = Compte_BancaireService;
    }
    @PostMapping(path = "/add")
    public Compte_Bancaire addCompte(@RequestBody Compte_Bancaire compte) {
        return Compte_BancaireService.addCompte(compte);
    }

    @GetMapping(path = "/get/{id}")
    public Compte_Bancaire getCompte (@PathVariable("id") Long id){
        return Compte_BancaireService.getCompte(id);
    }

    @GetMapping(path = "/get")
    public List<Compte_Bancaire> getAllComptes(){
        return Compte_BancaireService.getAllComptes();
    }
    @PutMapping(path = "/update/{id}")
    public Compte_Bancaire updateCompte(@PathVariable("id") Long id, @RequestBody Compte_Bancaire compte){
        return Compte_BancaireService.updateCompte(id, compte);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteCompte(@PathVariable("id") Long id){
        Compte_BancaireService.deleteCompte(id);
    }
}
