package com.example.ebank.Services;

import com.example.ebank.Entity.Wallet;
import com.example.ebank.Entity.WalletHistorique;
import com.example.ebank.Entity.typeWallet;
import com.example.ebank.Repository.IwalletHistoryRepo;
import com.example.ebank.Repository.IwalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class WalletService implements IwalletService {
    @Autowired

    private IwalletRepo iwalletRepo;
    @Autowired
    private IwalletHistoryRepo iwalletHistoryRepo;

    // Créez une instance de RestTemplate directement dans le service
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${exchangerate.api.url}")
    private String apiUrl;

    @Override
    public List<Wallet> getAllWallets() {
        return iwalletRepo.findAll();
    }
    @Override
    public List<Wallet> getAllWalletsByClientId(Long id) {
        return iwalletRepo.findByClientId(id).get();
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
            WalletHistorique walletHistorique=new WalletHistorique();
            walletHistorique.setCompte_Bancaire_Id(existingWallet.getCompteBancaire().getId());
            walletHistorique.setCurrency(newWalletData.getCurrency());
            walletHistorique.setDate_Creation(ZonedDateTime.now());
            walletHistorique.setAmount(newWalletData.getBalance());

            // Update existingWallet with data from newWalletData
            existingWallet.setCurrency(newWalletData.getCurrency());
            existingWallet.setDate_modification(newWalletData.getDate_modification());
            existingWallet.setClient(newWalletData.getClient());
            double Indinar;
            if(newWalletData.getBalance()<existingWallet.getBalance()){
                Indinar =existingWallet.getBalance()-newWalletData.getBalance();
                walletHistorique.setTypeWallet(typeWallet.SOLD);
                walletHistorique.setAmount(Indinar);
            }else {
                Indinar =newWalletData.getBalance()-existingWallet.getBalance();
                walletHistorique.setTypeWallet(typeWallet.BOUGHT);
                walletHistorique.setAmount(Indinar);
            }

            existingWallet.setBalance(newWalletData.getBalance());


            iwalletHistoryRepo.saveAndFlush(walletHistorique);
            return iwalletRepo.save(existingWallet);
        } else {
            // Handle case where wallet with given id is not found
            return null;
        }    }

    @Override
    public void deleteWallet(Long id) {
        iwalletRepo.deleteById(id);

    }
    public double convertCurrency(String from, String to, double amount) {
        // Créez l'URL en utilisant l'API URL
        String url = String.format("%s/%s", apiUrl, from);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response == null) {
            throw new RuntimeException("Failed to fetch exchange rate.");
        }
        Map<String, Double> rates = (Map<String, Double>) response.get("rates");
        if (rates == null || !rates.containsKey(to)) {
            throw new RuntimeException("Exchange rate for currency pair not found.");
        }
        double rate = rates.get(to);
        return amount * rate;
    }
}
