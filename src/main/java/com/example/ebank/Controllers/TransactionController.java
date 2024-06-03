package com.example.ebank.Controllers;

import com.example.ebank.Services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Transactions")
public class TransactionController {
    private final ITransactionService TransactionService;

    @Autowired
    public TransactionController(ITransactionService TransactionService) {
        this.TransactionService = TransactionService;
    }
}
