package com.example.ebank.Controllers;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Services.ITransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Transferts")
public class TransfertController {
    private final ITransfertService TransfertService;

    @Autowired
    public TransfertController(ITransfertService TransfertService) {
        this.TransfertService = TransfertService;
    }

    @PostMapping(path = "/add")
    public Transfert addTransfert(@RequestBody Transfert transfert) {
        return TransfertService.addTransfert(transfert);
    }

    @GetMapping(path = "/get/{id}")
    public Transfert getTransfert (@PathVariable("id") Long id){
        return TransfertService.getTransfert(id);
    }

    @GetMapping(path = "/getAll/{id}")
    public List<Transfert> getAllTranfertsByCompte(@PathVariable("id") Long id){
        return TransfertService.getAllTranfertsByCompte(id);
    }
    @GetMapping(path = "/get")
    public List<Transfert> getAllTransferts(){
        return TransfertService.getAllTransferts();
    }
}
