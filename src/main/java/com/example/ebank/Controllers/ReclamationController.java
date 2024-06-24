package com.example.ebank.Controllers;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Services.IreclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {

    @Autowired
    private IreclamationService ireclamationService;

    @GetMapping("/retrieveAllReclamations")
    public List<Reclamation> retrieveAllReclamations() {
        return ireclamationService.retrieveAllReclamations();
    }

    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return ireclamationService.addReclamation(reclamation);
    }

    @DeleteMapping("/deleteReclamation/{id}")
    public String deleteReclamation(@PathVariable("id") Long id) {
        return ireclamationService.deleteReclamation(id);
    }

    @GetMapping("/retrieveReclamation/{id}")
    public ResponseEntity<Reclamation> retrieveReclamation(@PathVariable("id") Long id) {
        Reclamation reclamation = ireclamationService.retrieveReclamation(id);
        if (reclamation != null) {
            return ResponseEntity.ok(reclamation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable("id") Long id, @RequestBody Reclamation newReclamationData) {
        Reclamation updatedReclamation = ireclamationService.updateReclamation(id, newReclamationData);
        if (updatedReclamation != null) {
            return ResponseEntity.ok(updatedReclamation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
