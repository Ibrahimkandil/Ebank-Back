package com.example.ebank.Services;

import com.example.ebank.Entity.*;
import com.example.ebank.Repository.*;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeOutputDto;
import com.example.ebank.Services.Dtos.ReclamationDtos.ReclamationOutputDto;
import com.example.ebank.Services.Dtos.TransactionDtos.TransactionOutputDto;
import com.example.ebank.Services.Dtos.TransfertDtos.TransfertOutputDto;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import com.example.ebank.Services.Mappers.Compte_BancaireMappers.Compte_BancaireOutputMapper;
import com.example.ebank.Services.Mappers.DemandeMappers.DemandeOutputMapper;
import com.example.ebank.Services.Mappers.ReclamationMappers.ReclamationOutputMapper;
import com.example.ebank.Services.Mappers.TransactionMappers.TransactionOutputMapper;
import com.example.ebank.Services.Mappers.TransfertMappers.TransfertOutputMapper;
import com.example.ebank.Services.Mappers.contrat_preteMappers.contrat_preteOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientRepo iclientRepo;
    @Autowired
    private ClientOutputMapper clientOutputMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientInputMapper clientInputMapper;
    @Autowired
    private IEmployeeRepo employeeRepo;
    @Autowired
    private TransfertRepository transfertRepository;
    @Autowired
    private Compte_BancaireRepository compte_bancaireRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionOutputMapper transactionOutputMapper;
    @Autowired
    private Compte_BancaireOutputMapper compteBancaireOutputMapper;
    @Autowired
    private TransfertOutputMapper transfertOutputMapper;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private DemandeRepoisitory demandeRepoisitory;
    @Autowired
    private contrat_preteOutputMapper contratPreteOutputMapper;
    @Autowired
    private DemandeOutputMapper demandeOutputMapper;
    @Autowired
    private ReclamationOutputMapper reclamationOutputMapper;
    @Autowired
    private IreclamationRepo reclamationRepository;


    @Override
    public List<ClientOutputDto> getAllClients() {
        List<Client> clients = this.iclientRepo.findAll();
        return clients.stream()
                .map(clientOutputMapper::toDto)// Map each Client entity to ClientOutputDto using the mapper
                .collect(Collectors.toList()); // Collect the mapped ClientOutputDto objects into a list
    }
//    public List<ClientOutputDto> getAllClients() {
//        List<Client> clients = this.iclientRepo.findAll();
//        return clients; // Collect the mapped ClientOutputDto objects into a list
//    }


    @Override
    public ClientOutputDto getClient(String identification, String password) {
        Client c =  this.iclientRepo.findByIdentificationAndPassword(identification, password);
        return  clientOutputMapper.toDto(c);
    }

    @Override
    public ClientOutputDto getClientById(long id) {
        Client c = this.iclientRepo.findById(id).get();
        return clientOutputMapper.toDto(c);

    }

    @Override
    public ClientOutputDto addClient(Long id ,ClientInputDto client) {
    Client c = clientInputMapper.toEntity(client);
    c.setIdentificationNumber(c.Genrateur_Identification());
    c.setPassword(c.Genrateur_Motsdupasse());
        Employee e = this.employeeRepo.findById(id).get();
       c.setAddedBy(e);
        ZonedDateTime now = ZonedDateTime.now();
        c.setDate_d_ajout(now);
    c = this.iclientRepo.save(c);

        return clientOutputMapper.toDto(c);
    }

    @Override
    public ClientOutputDto updateClient(ClientInputDto client) {
        Client c = clientInputMapper.toEntity(client);
       Client c1 = this.iclientRepo.findById(c.getId()).get();
       clientInputMapper.partialUpdate(c1,client);
       iclientRepo.saveAndFlush(c1);

        return clientOutputMapper.toDto(c1);
    }

    @Override
    public void deleteClient(long id) {
        Client c = this.iclientRepo.findById(id).get();
        this.iclientRepo.delete(c);
    }


    public Client getClientByIdentificationNumber(String id) {
        Client client = iclientRepo.findByIdentificationNumber(id);
        return client;
    }

    public String resetPassword(Long id ,String password) {
        String decryptedPassword = decrypt(password);
        Client client = iclientRepo.findById(id).get();
        client.setPassword(decryptedPassword);
        iclientRepo.save(client);
        return "Password reset successfully";
    }
    public Client getClientByEmail(String email){
        Client client = iclientRepo.findByEmail(email).get();
        return client;
    }

    private  static final   String  SECRET_KEY = "verification"; // Replace with your actual secret key
    private static final String SALT = "your_salt"; // Replace with your actual salt

    public static String decrypt(String strToDecrypt) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
            return new String(decryptedBytes);
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
            return null;
        }
    }



    public List<Object> getAllHistorique(long id){
        List<Transaction> transactions= this.transactionRepository.findByIdClient(id).get();
        List<TransactionOutputDto> transactionOutputDtos=transactions.stream().map(transactionOutputMapper::toDto).collect(Collectors.toList());
        List<Transfert> transferts = this.transfertRepository.findByIdClient(id).get();
        List<TransfertOutputDto> transfertOutputDtos=transferts.stream().map(transfertOutputMapper::toDto).collect(Collectors.toList());

        List<Object> objects= new ArrayList<>();
        objects.add(transactionOutputDtos);
        objects.add(transfertOutputDtos);
        return objects;

    }
    public List<Compte_BancaireOutputDto> getCompteById(long id){
        List<Compte_Bancaire> comptes = this.compte_bancaireRepository.findByIdClient(id).get();

        List<Compte_BancaireOutputDto> compteBancaireOutputDtos=comptes.stream().map(compteBancaireOutputMapper::toDto).collect(Collectors.toList());

        return compteBancaireOutputDtos;

    }
    public List<Object> getNotifications(long id){
        List<contrat_prete> contrat_pretes= this.contratRepository.findByIdClient(id).get();
        List<contrat_preteOutputDto> contratPreteOutputDtos=contrat_pretes.stream().map(contratPreteOutputMapper::toDto).collect(Collectors.toList());
        List<Demande> demandes= this.demandeRepoisitory.findByIdClient(id).get();
        List<DemandeOutputDto> demandeOutputDtos=demandes.stream().map(demandeOutputMapper::toDto).collect(Collectors.toList());


        List<Reclamation> reclamations= this.reclamationRepository.findByIdClient(id).get();
        List<ReclamationOutputDto> reclamationOutputDtos=reclamations.stream().map(reclamationOutputMapper::toDto).collect(Collectors.toList());
        demandeOutputDtos.forEach(demandeOutputDto -> {
            demandeOutputDto.setTypeObj("DEMANDE");
        });
        contratPreteOutputDtos.forEach(contrat_preteOutputDto -> {
            contrat_preteOutputDto.settype("CONTRAT");
        });
        reclamationOutputDtos.forEach(reclamationOutputDto -> {
            reclamationOutputDto.setType("RECLAMATION");
        });
        List<Object> objects= new ArrayList<>();
        objects.add(demandeOutputDtos);
        objects.add(contratPreteOutputDtos);
        objects.add(reclamationOutputDtos);
        //contrat prete
        //Demande
        //reclamation

        return objects;

    }


}

