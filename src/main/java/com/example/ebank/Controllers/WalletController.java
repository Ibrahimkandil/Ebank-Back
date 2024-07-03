package com.example.ebank.Controllers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Wallet;
import com.example.ebank.Repository.Compte_BancaireRepository;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IwalletRepo;
import com.example.ebank.Services.Dtos.WalletDtos.WalletInputDto;
import com.example.ebank.Services.Dtos.WalletDtos.WalletOutputDto;
import com.example.ebank.Services.Mappers.WalletMappers.WalletInputMapper;
import com.example.ebank.Services.Mappers.WalletMappers.WalletOutputMapper;
import com.example.ebank.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;
    @Autowired
    private WalletInputMapper walletInputMapper;
    @Autowired
    private IClientRepo iclientRepo;
    @Autowired
    private WalletOutputMapper walletOutputMapper;
    @Autowired
    private IwalletRepo iwalletRepo;
    @Autowired
    private Compte_BancaireRepository compteBancaireRepository;
    // Créez une instance de RestTemplate directement dans le contrôleur
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${exchangerate.api.url}")
    private String apiUrl;
    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("all/{id}")
    public List<Wallet> getWalletByClientId(@PathVariable  Long id) {
        List<Wallet> wallets = walletService.getAllWalletsByClientId(id);
            return wallets;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable  Long id) {
        Optional<Wallet> wallet = walletService.getWalletById(id);
        return wallet.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id_compte}")
    public ResponseEntity<Object> createWallet(@PathVariable Long id_compte ,@RequestBody WalletInputDto wallet) throws Exception {
        try {
            Compte_Bancaire compteBancaire=compteBancaireRepository.findById(id_compte).get();
        Client client = this.iclientRepo.findById(wallet.getId_client()).get();
        Wallet Wallet = this.walletInputMapper.toEntity(wallet);
            compteBancaire.setBalance(compteBancaire.getBalance()-Wallet.getBalance());
            compteBancaireRepository.saveAndFlush(compteBancaire);

            Wallet.setClient(client);
        Wallet createdWallet = walletService.createWallet(Wallet);
        WalletOutputDto outputWallet = this.walletOutputMapper.toDto(createdWallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputWallet);
        }catch( Exception e ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Saugarde de Wallet");

        }
//        Wallet createdWallet = walletService.createWallet(wallet);
//        return new ResponseEntity<>(createdWallet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable Long id, @RequestBody Wallet wallet) {
        Wallet updatedWallet = walletService.updateWallet(id, wallet);
        if (updatedWallet != null) {
            return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/convert")
    public double convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        return convertCurrencyUsingApi(from, to, amount);
    }

    private double convertCurrencyUsingApi(String from, String to, double amount) {
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
    @PostMapping("/Bycurrency")
    public ResponseEntity<Object> getWalletByClientIdAndCurrency(@RequestBody currencyName currencyName) throws Exception {
        try{
        Wallet wallet = iwalletRepo.findByClientIdAndCurrency(currencyName.getId_client(), currencyName.getCurrency()).get();
        WalletOutputDto  outputWallet=this.walletOutputMapper.toDto(wallet);
        return ResponseEntity.status(HttpStatus.OK).body(outputWallet);
    }catch( Exception e ) {
        return ResponseEntity.status(HttpStatus.OK).body("CREATE");

    }
    }
}
class currencyName{
    private String currency;
    private long id_client;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }
}
