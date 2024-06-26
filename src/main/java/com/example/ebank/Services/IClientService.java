package com.example.ebank.Services;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;

import java.util.List;
import java.util.Objects;


public interface IClientService {
    public List<Object> getNotifications(long id);
public List<Compte_BancaireOutputDto> getCompteById(long id);
    public List<Object> getAllHistorique(long id);
    public List<ClientOutputDto> getAllClients();
//    public List<Client> getAllClients();
    public ClientOutputDto getClient(String identification, String password);
    public ClientOutputDto getClientById(long id);
    public ClientOutputDto addClient(Long id ,ClientInputDto client);
    public ClientOutputDto updateClient(ClientInputDto client);
    public void deleteClient(long id);
    public Client getClientByIdentificationNumber(String id);

}
