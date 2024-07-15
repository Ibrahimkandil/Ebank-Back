package com.example.ebank.Services;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Transaction;
import com.example.ebank.Repository.ICompte_BancaireRepo;
import com.example.ebank.Repository.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService{
    private final ITransactionRepo TransactionRepo ;
    private final ICompte_BancaireRepo Compte_BancaireRepo;

    @Autowired
    public TransactionService(ITransactionRepo TransactionRepo, ICompte_BancaireRepo Compte_BancaireRepo) {
        this.TransactionRepo = TransactionRepo;
        this.Compte_BancaireRepo = Compte_BancaireRepo;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        /*
        Optional<Compte_Bancaire> oldCompte = Compte_BancaireRepo.findById(transaction.getClient().getId());
        if (oldCompte.isPresent()) {
            Compte_Bancaire compte = oldCompte.get();
            if(transaction.getType().equals("DEPOSIT")){
                compte.setBalance(oldCompte.get().getBalance() + transaction.getAmount());
            }
            else{
                compte.setBalance(oldCompte.get().getBalance() - transaction.getAmount());
            }
            Compte_BancaireRepo.save(compte);
        }
         */

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
