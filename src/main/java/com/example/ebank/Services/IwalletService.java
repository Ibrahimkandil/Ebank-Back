package com.example.ebank.Services;

import com.example.ebank.Entity.Wallet;

import java.util.List;
import java.util.Optional;

public interface IwalletService {
    List<Wallet> getAllWalletsByClientId(Long id);
    List<Wallet> getAllWallets();
    Optional<Wallet> getWalletById(Long id);
    Wallet createWallet(Wallet wallet);
    Wallet updateWallet(Long id, Wallet newWalletData);
    void deleteWallet(Long id);
     double convertCurrency(String from, String to, double amount) ;

    }
