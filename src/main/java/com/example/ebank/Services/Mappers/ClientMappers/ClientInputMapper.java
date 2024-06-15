package com.example.ebank.Services.Mappers.ClientMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})


public abstract class ClientInputMapper  implements EntityMapper<ClientInputDto, Client> {

    public abstract Client toEntity(ClientInputDto dto) ;


    public abstract ClientInputDto toDto(Client entity) ;

    public Client partialUpdate(Client entity,Client c1) {
        if (c1.getLast_name() != null) {
            entity.setLast_name(c1.getLast_name());
        }
        if (c1.getFirst_name() != null) {
            entity.setFirst_name(c1.getFirst_name());
        }
        if (c1.getAddress() != null) {
            entity.setAddress(c1.getAddress());
        }
        if (c1.getPhone() != null) {
            entity.setPhone(c1.getPhone());
        }
        if (c1.getEmail() != null) {
            entity.setEmail(c1.getEmail());
        }
        if (c1.getDate_of_birth() != null) {
            entity.setDate_of_birth(c1.getDate_of_birth());
        }
        if (c1.getSexe() != null) {
            entity.setSexe(c1.getSexe());
        }
        if (c1.getImage_data() != null) {
            entity.setImage_data(c1.getImage_data());
        }
        if (c1.getEtatCivil() != null) {
            entity.setEtatCivil(c1.getEtatCivil());
        }
        if (c1.getStatutEmploi() != null) {
            entity.setStatutEmploi(c1.getStatutEmploi());
        }
        return entity;
    }




}
