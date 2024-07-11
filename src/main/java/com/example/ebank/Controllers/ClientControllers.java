package com.example.ebank.Controllers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Controlle;
import com.example.ebank.Entity.EtatCompte;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IControlleRepo;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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