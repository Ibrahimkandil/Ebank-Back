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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private WalletOutputMapper WalletOutputMapper;
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
    public List<WalletOutputDto> getWalletByClientId(@PathVariable  Long id) {
        List<Wallet> wallets = walletService.getAllWalletsByClientId(id);
        List<WalletOutputDto> walletOutputDtos=wallets.stream().map(WalletOutputMapper::toDto).collect(Collectors.toList());

        return walletOutputDtos;
    }
    @GetMapping("allById_clientANDid_compte/{id_client}/{id_compte}")
    public List<WalletOutputDto> getWalletByClientId(@PathVariable  Long id_client,@PathVariable  Long id_compte) {
        List<Wallet> wallets = iwalletRepo.getAllWalletsByClientIdANDCompteId(id_client,id_compte).get();
        List<WalletOutputDto> walletOutputDtos=wallets.stream().map(WalletOutputMapper::toDto).collect(Collectors.toList());

        return walletOutputDtos;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable  Long id) {
        Optional<Wallet> wallet = walletService.getWalletById(id);
        return wallet.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PatchMapping("updateWallet")
    public  ResponseEntity<Object> UpdateWallet(@RequestBody UpdateDataWallet updateDataWallet){
        Wallet wallet = iwalletRepo.findById(updateDataWallet.getId_wallet()).get();
        Compte_Bancaire compteBancaire=compteBancaireRepository.findById(wallet.getCompteBancaire().getId()).get();

        if(updateDataWallet.getNew_Balance()>0){

            double Indinar=(updateDataWallet.getNew_Balance()-wallet.getBalance())/updateDataWallet.getRate();
            wallet.setBalance(updateDataWallet.getNew_Balance());
            wallet.setDate_modification(new Date().toString());
            iwalletRepo.saveAndFlush(wallet);
            compteBancaire.setBalance(compteBancaire.getBalance()-Indinar);
            compteBancaireRepository.saveAndFlush(compteBancaire);

            return ResponseEntity.status(HttpStatus.OK).body("Wallet Updated");
        }else {
            compteBancaire.setBalance(compteBancaire.getBalance()+wallet.getBalance()/updateDataWallet.getRate());
            compteBancaireRepository.saveAndFlush(compteBancaire);
            iwalletRepo.deleteById(updateDataWallet.getId_wallet());
            return ResponseEntity.status(HttpStatus.OK).body("Wallet DELETED");




        }

    }

    @PostMapping("/{id_compte}")
    public ResponseEntity<Object> createWallet(@PathVariable Long id_compte ,@RequestBody WalletInputDto wallet) throws Exception {
        try {
            Compte_Bancaire compteBancaire=compteBancaireRepository.findById(id_compte).get();
        Client client = this.iclientRepo.findById(wallet.getId_client()).get();
        Wallet Wallet = this.walletInputMapper.toEntity(wallet);
        Wallet.setCompteBancaire(compteBancaire);
        Wallet.setDate_modification(new Date().toString());
        double Indinar=Wallet.getBalance()/wallet.getRate();
            compteBancaire.setBalance(compteBancaire.getBalance()-Indinar);
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
    public ResponseEntity<Object> getWalletByClientIdAndCurrency(@RequestBody currencyName currencyName) {
        Wallet wallet = iwalletRepo.findByClientIdAndCurrency(currencyName.getId_client(), currencyName.getCurrency(),currencyName.getAccount_number());
        WalletOutputDto outputWallet = this.walletOutputMapper.toDto(wallet);

        if (outputWallet != null) {
            return ResponseEntity.status(HttpStatus.OK).body(outputWallet);
        } else {


            return ResponseEntity.status(HttpStatus.OK).body("CREATE");
        }

    }
}
class currencyName{
    private String currency;
    private Long id_client;
    private String account_number;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }
}
class UpdateDataWallet {
    Long id_wallet;
    double rate;
    double new_Balance;


    public Long getId_wallet() {
        return id_wallet;
    }

    public void setId_wallet(Long id_wallet) {
        this.id_wallet = id_wallet;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getNew_Balance() {
        return new_Balance;
    }

    public void setNew_Balance(double new_Balance) {
        this.new_Balance = new_Balance;
    }
}
