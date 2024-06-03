package com.example.ebank.Controllers;

import com.example.ebank.Services.ITransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Transferts")
public class TransfertController {
    private final ITransfertService TransfertService;

    @Autowired
    public TransfertController(ITransfertService TransfertService) {
        this.TransfertService = TransfertService;
    }
}
