package com.example.ebank.Services;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IEmployeeRepo;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.time.ZonedDateTime;
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
}

