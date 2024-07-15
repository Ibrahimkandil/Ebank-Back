package com.example.ebank.Controllers;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/Transactions")
public class TransactionController {
    private final ITransactionService TransactionService;

    @Autowired
    public TransactionController(ITransactionService TransactionService) {
        this.TransactionService = TransactionService;
    }

    @PostMapping(path = "/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return TransactionService.addTransaction(transaction);
    }

    @GetMapping(path = "/get/{id}")
    public Transaction getTransaction (@PathVariable("id") Long id){
        return TransactionService.getTransaction(id);
    }

    @GetMapping(path = "/getAll/{id}")
    public List<Transaction> getAllTransactionsByUser(@PathVariable("id") Long id){
        return TransactionService.getAllTransactionsByUser(id);
    }
    @GetMapping(path = "/get")
    public List<Transaction> getAllTransaction(){
        return TransactionService.getAllTransactions();
    }
}
