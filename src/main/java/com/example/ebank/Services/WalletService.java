package com.example.ebank.Services;

import com.example.ebank.Entity.Wallet;
import com.example.ebank.Repository.IwalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WalletService implements IwalletService {
    @Autowired
    private IwalletRepo iwalletRepo;
    @Override
    public List<Wallet> getAllWallets() {
        return iwalletRepo.findAll();
    }

    @Override
    public Optional<Wallet> getWalletById(Long id) {
        return iwalletRepo.findById(id);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        return iwalletRepo.save(wallet);
    }

    @Override
    public Wallet updateWallet(Long id, Wallet newWalletData) {
        Optional<Wallet> optionalWallet = iwalletRepo.findById(id);
        if (optionalWallet.isPresent()) {
            Wallet existingWallet = optionalWallet.get();
            // Update existingWallet with data from newWalletData
            existingWallet.setCurrency(newWalletData.getCurrency());
            existingWallet.setDate_modification(newWalletData.getDate_modification());
            existingWallet.setClient(newWalletData.getClient());
            existingWallet.setBalance(newWalletData.getBalance());
            return iwalletRepo.save(existingWallet);
        } else {
            // Handle case where wallet with given id is not found
            return null;
        }    }

    @Override
    public void deleteWallet(Long id) {
        iwalletRepo.deleteById(id);

    }
}
