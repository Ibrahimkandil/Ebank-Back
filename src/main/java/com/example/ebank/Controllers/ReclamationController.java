package com.example.ebank.Controllers;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Services.IreclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reclamation")
public class ReclamationController {


    @Autowired
    IreclamationService ireclamationService;

    @GetMapping("/retrieveAllReclamations")
    public List<Reclamation> retrieveAllReclamations() {
        return ireclamationService.retrieveAllReclamations();
    }

    @PostMapping("/addReclamation")
    public Reclamation addReclamation (@RequestBody Reclamation reclamation){
        return ireclamationService.addReclamation(reclamation);
    }
    @DeleteMapping("/deleteReclamation/{id}")
    public String deleteReclamation(@PathVariable("id") Long id){
        return ireclamationService.deleteReclamation(id);
    }


}
