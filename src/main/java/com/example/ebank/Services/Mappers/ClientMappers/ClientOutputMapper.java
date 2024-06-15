package com.example.ebank.Services.Mappers.ClientMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})


public abstract class ClientOutputMapper  implements EntityMapper<ClientOutputDto, Client> {
    public abstract Client toEntity(ClientOutputDto dto) ;
    public abstract ClientOutputDto toDto(Client entity) ;

    Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }

}
