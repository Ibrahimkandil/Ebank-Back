package com.example.ebank.Controllers;

import com.example.ebank.Entity.*;
import com.example.ebank.Repository.*;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeOutputDto;
import com.example.ebank.Services.Dtos.WalletDtos.WalletOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import com.example.ebank.Services.Mappers.Compte_BancaireMappers.Compte_BancaireOutputMapper;
import com.example.ebank.Services.Mappers.DemandeMappers.DemandeOutputMapper;
import com.example.ebank.Services.Mappers.WalletMappers.WalletOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.ebank.Services.Mappers.contrat_preteMappers.contrat_preteOutputMapper;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteOutputDto;


@RestController
@RequestMapping("api/v1/client")

public class ClientControllers {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientOutputMapper clientOutputMapper;
    @Autowired
    private IClientRepo iClientRepo;
    @Autowired
    private ClientInputMapper clientInputMapper;
    @Autowired
    private IControlleRepo iControlleRepo;
    @Autowired
    private IwalletRepo iwalletRepo;
    @Autowired
    private Compte_BancaireRepository compteBancaireRepository;
    @Autowired
    private DemandeRepoisitory demandeRepoisitory;
    @Autowired
    private WalletOutputMapper walletOutputMapper;
    @Autowired
    private Compte_BancaireOutputMapper Compte_BancaireOutputMapper;
    @Autowired
    private DemandeOutputMapper demandeOutputMapper;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private contrat_preteOutputMapper contratPreteOutputMapper;
    @Autowired
    private IwalletHistoryRepo iwalletHistoryRepo;




    @GetMapping
    public  String SayHello(){
        return "Hello it's Client";
    }
    @GetMapping("/all")
    public List<ClientOutputDto> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public ClientOutputDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PatchMapping("Confirmation_compte/{id}")
    public ResponseEntity<Object> Confirmation_compte(@PathVariable Long id, @RequestBody SignatureCompte signature) throws Exception {
        try {
            Controlle controlle = iControlleRepo.getControlleByClientIdANDType(id, "CLIENT").get();
            controlle.setConfirmation(signature.getImage_data());
            controlle.setEtatCompte(EtatCompte.ACTIF);
            iControlleRepo.saveAndFlush(controlle);
            return ResponseEntity.ok().body("{\"message\": \"Votre compte est ACTIF\"}");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("{\"message\": \"Erreur lors d'Activation\"}");
        }
    }
    @PatchMapping("Demande_Suppression/{id}")
    public ResponseEntity<Object> Demande_Suppression(@PathVariable Long id, @RequestBody SignatureCompte signature) throws Exception {
        try {
            Controlle controlle = iControlleRepo.getControlleByClientIdANDType(id, "CLIENT").get();
            controlle.setDemande_suppression(signature.getImage_data());
            controlle.setEtatCompte(EtatCompte.DEMANDE);
            iControlleRepo.saveAndFlush(controlle);
            return ResponseEntity.ok().body("{\"message\": \"Demande de suppression a était accepté\"}");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("{\"message\": \"Erreur lors de l'Enregistrement du Demande du Suppression\"}");
        }
    }
@PatchMapping("Update/{id}")
public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody ClientInputDto client) throws  Exception {
        try {
            Client client1 = iClientRepo.findById(id).get();

            clientInputMapper.partialUpdate(client1, client);
            Client C=iClientRepo.saveAndFlush(client1);
            return ResponseEntity.ok().body(clientOutputMapper.toDto(C));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("{\"message\": \"Erreur lors de la mise à jour des données du client\"}");

        }
}
    @PostMapping("/reset/{id}")
        public String resetPassword(@PathVariable Long id, @RequestBody PasswordRequest password) {
            return clientService.resetPassword(id, password.getPassword());
        }
            @GetMapping("/historiques/{id}")
    public List<Object> getAllHistorique(@PathVariable Long id) {
        return clientService.getAllHistorique(id);
    }
    @GetMapping("/comptes/{id}")
    public List<Compte_BancaireOutputDto> getCompteById(@PathVariable Long id) {
        return clientService.getCompteById(id);
    }
    @GetMapping("/notifications/{id}")
    public List<Object> getNotifications(@PathVariable Long id) {
        return clientService.getNotifications(id);
    }


@PostMapping("changerPass/{id}")
    public ResponseEntity<Object> changerPassword(@PathVariable Long id, @RequestBody ChangerPassword changerPassword) {
    Client client=iClientRepo.findById(id).get();
    if(client.getPassword().equals(changerPassword.getPassword())) {
        client.setPassword(changerPassword.getNewPassword());
        iClientRepo.saveAndFlush(client);
        return ResponseEntity.ok().body("{\"message\": \"Password Changed Successfully\"}");

    }else{
        return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"Erroor Password Typed and password In DB are not the Same\"}");

    }

    }

    @GetMapping("/fetchData/{id}")
    public ResponseEntity<Object> fetchData(@PathVariable Long id) throws  Exception{
        try {


        List Objects = new ArrayList();
        List<Wallet> wallets = iwalletRepo.findByClientId(id).get();
        List<WalletOutputDto> walletOutputDtos=wallets.stream().map(walletOutputMapper::toDto).collect(Collectors.toList());

            List<Compte_Bancaire> compteBancaires= compteBancaireRepository.findByIdClient(id).get();
            List<Compte_BancaireOutputDto> compteBancaireOutputDtos=compteBancaires.stream().map(Compte_BancaireOutputMapper::toDto).collect(Collectors.toList());

            List<Demande> demandes = demandeRepoisitory.findByIdClientAndEtat(id).get();
            List<DemandeOutputDto> demandeOutputDtos=demandes.stream().map(demandeOutputMapper::toDto).collect(Collectors.toList());
            List<contrat_prete> contrat_pretes= this.contratRepository.findByIdClientAAndEtatContrat(id,etatContrat.ACTIF).get();
            List<contrat_preteOutputDto> contratPreteOutputDtos=contrat_pretes.stream().map(contratPreteOutputMapper::toDto).collect(Collectors.toList());



            Map<String , List<WalletOutputDto>> map = Map.of("wallets",walletOutputDtos);
        Map<String , List<Compte_BancaireOutputDto>> map1 = Map.of("compteBancaires",compteBancaireOutputDtos);
        Map<String , List<DemandeOutputDto>> map2 = Map.of("demandes",demandeOutputDtos);
        Map<String , List<contrat_preteOutputDto>> map3 = Map.of("contrats",contratPreteOutputDtos);

        Objects.add(map);
        Objects.add(map1);
        Objects.add(map2);
        Objects.add(map3);
            return ResponseEntity.ok().body(Objects);

        }catch (Exception e){
            return ResponseEntity.internalServerError().body("{\"message\": \"Erreur lors de la récupération des données\"}");

        }


    }

    @DeleteMapping("/ClearDatas/{id}")
    public ResponseEntity<Object> ClearDatas(@PathVariable Long id) {
        try {
            List<Wallet> wallets = iwalletRepo.findByClientId(id).get();
            List<Compte_Bancaire> compteBancaires= compteBancaireRepository.findByIdClient(id).get();
            List<Demande> demandes = demandeRepoisitory.findByIdClient(id).get();
            List<contrat_prete> contrat_pretes= this.contratRepository.findByIdClient(id).get();
            for(Wallet wallet:wallets){
                WalletHistorique wh=new WalletHistorique();
                wh.setAmount(wallet.getBalance());
                wh.setCurrency(wallet.getCurrency());
                wh.setCompte_Bancaire_Id(wallet.getCompteBancaire().getId());
                wh.setTypeWallet(typeWallet.SOLD);
                wh.setDate_Creation(ZonedDateTime.now());
                iwalletHistoryRepo.saveAndFlush(wh);
                wallet.setBalance(0);
                iwalletRepo.saveAndFlush(wallet);

            }
            for(Compte_Bancaire compteBancaire:compteBancaires){
                compteBancaire.setBalance(0);
                compteBancaireRepository.saveAndFlush(compteBancaire);
            }

            for(Demande demande:demandes){

                demandeRepoisitory.deleteByIdClient(demande.getClient().getId());
            }

//            iwalletRepo.deleteAll(wallets);
//            compteBancaireRepository.deleteAll(compteBancaires);
//            demandeRepoisitory.deleteAll(demandes);
//            contratRepository.deleteAll(contrat_pretes);
            return ResponseEntity.ok().body("{\"message\": \"Données supprimées avec succès\"}");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("{\"message\": \"Erreur lors de la suppression des données\"}");
        }
    }
}

class  PasswordRequest {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
class ChangerPassword  {
        private String password;
        private String newPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}