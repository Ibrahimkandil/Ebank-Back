package com.example.ebank.Services;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;

import java.util.List;


public interface IClientService {
    public List<ClientOutputDto> getAllClients();
//    public List<Client> getAllClients();
    public ClientOutputDto getClient(String identification, String password);
    public ClientOutputDto getClientById(long id);
    public ClientOutputDto addClient(Long id ,ClientInputDto client);
    public ClientOutputDto updateClient(ClientInputDto client);
    public void deleteClient(long id);
    public Client getClientByIdentificationNumber(String id);

}
