package com.example.ebank.Services;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Repository.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{
    private final ITransactionRepo TransactionRepo ;

    @Autowired
    public TransactionService(ITransactionRepo TransactionRepo) {
        this.TransactionRepo = TransactionRepo;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return TransactionRepo.save(transaction);
    }

    @Override
    public Transaction getTransaction(Long id) {
        Optional<Transaction> transaction = TransactionRepo.findById(id);
        if (transaction.isPresent()) {
            return transaction.get();
        }
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return TransactionRepo.findAll();
    }

    @Override
    public List<Transaction> getAllTransactionsByUser(Long id) {
        List<Transaction> AllTransactions = getAllTransactions();
        List<Transaction> transactionsByUser = new ArrayList<>();

        for (Transaction transaction : AllTransactions) {
            if (transaction.getClient().getId().equals(id)) {
                transactionsByUser.add(transaction);
            }
        }
        return transactionsByUser;
    }
}
