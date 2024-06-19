package com.example.ebank.Controllers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.contrat_prete;
import com.example.ebank.Services.ContratService;
import com.example.ebank.Services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee/contrat")
public class ContratControlleur {
    @Autowired
    private ContratService contratService;

    public List<contrat_prete> getALLcontrat_pretes() {
        return contratService.getAllcontrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<contrat_prete> getcontratById(@PathVariable Long id) {
        Optional<contrat_prete> contrat_prete = contratService.getcontratById(id);
        return contrat_prete.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<contrat_prete> creatcontrat_prete(@RequestBody contrat_prete contrat_prete) {
        contrat_prete creatcontrat_prete = contratService.createcontrat_prete(contrat_prete);
        return new ResponseEntity<>(creatcontrat_prete, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<contrat_prete> updatecontrat_prete(@PathVariable Long id, @RequestBody contrat_prete contrat_prete) {
        contrat_prete updatecontrat_prete = contratService.updatecontrat_prete(id,contrat_prete);
        if (updatecontrat_prete != null) {
            return new ResponseEntity<>(updatecontrat_prete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletecontrat_prete(@PathVariable Long id) {
        contratService.deletecontrat_prete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
