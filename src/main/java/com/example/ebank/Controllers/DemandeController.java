package com.example.ebank.Controllers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.Wallet;
import com.example.ebank.Services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client/demande")
public class DemandeController {


    @Autowired
    private DemandeService demandeService;
    @GetMapping
    public List<Demande> getALLDemandes() {
        return demandeService.getAlldemandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        Optional<Demande> demande = demandeService.getdemandeById(id);
        return demande.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Demande> createdemande(@RequestBody Demande demande) {
        Demande createdemande = demandeService.createdemande(demande);
        return new ResponseEntity<>(createdemande, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable Long id, @RequestBody Demande demande) {
        Demande updateDemande = demandeService.updatedemande(id,demande);
        if (updateDemande != null) {
            return new ResponseEntity<>(updateDemande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeService.deletedemande(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
