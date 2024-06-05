package com.example.ebank.Services;

import com.example.ebank.Entity.Transaction;
import java.util.List;

public interface ITransactionService {

    Transaction addTransaction(Transaction transaction);
    Transaction getTransaction(Long id);
    List<Transaction> getAllTransactions();
    List<Transaction> getAllTransactionsByUser(Long id);
}
