package com.example.ebank.Services;

import com.example.ebank.Repository.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService{
    private final ITransactionRepo TransactionRepo ;

    @Autowired
    public TransactionService(ITransactionRepo TransactionRepo) {
        this.TransactionRepo = TransactionRepo;
    }
}
