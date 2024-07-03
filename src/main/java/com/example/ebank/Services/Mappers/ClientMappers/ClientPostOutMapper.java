package com.example.ebank.Services.Mappers.ClientMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import jakarta.persistence.Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class ClientPostOutMapper implements EntityMapper<ClientPostOutputDto, Client> {
    public abstract Client toEntity(ClientPostOutputDto dto) ;
    public abstract ClientPostOutputDto toDto(Client entity) ;

    Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
