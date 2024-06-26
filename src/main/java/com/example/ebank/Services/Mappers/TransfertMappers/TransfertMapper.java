package com.example.ebank.Services.Mappers.TransfertMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Services.Dtos.ClientDtos.ClientDto;
import com.example.ebank.Services.Dtos.TransfertDtos.TransfertDto;
import com.example.ebank.Services.Dtos.TransfertDtos.TransfertInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class TransfertMapper implements EntityMapper<TransfertDto, Transfert> {
    public abstract TransfertDto toDto(Transfert client);

    public abstract Transfert toEntity(TransfertDto clientDto);
    public Transfert partialUpdate(Transfert entity, Transfert c1) {

        if (c1.getAmount() != 0) {
            entity.setAmount(c1.getAmount());
        }
        if (c1.getDate() != null) {
            entity.setDate(c1.getDate());
        }
        if (c1.getIdCompteDestinations() != null) {
            entity.setIdCompteDestinations(c1.getIdCompteDestinations());
        }
        if (c1.getIdCompteSource() != null) {
            entity.setIdCompteSource(c1.getIdCompteSource());
        }

        return entity;

    }


}
