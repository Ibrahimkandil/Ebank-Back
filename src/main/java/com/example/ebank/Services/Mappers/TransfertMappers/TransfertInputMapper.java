package com.example.ebank.Services.Mappers.TransfertMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireInputDto;
import com.example.ebank.Services.Dtos.TransfertDtos.TransfertInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", uses = {})

public abstract class TransfertInputMapper implements EntityMapper<TransfertInputDto, Transfert> {
    public abstract Transfert toEntity(TransfertInputDto dto) ;


    public abstract TransfertInputDto toDto(Transfert entity) ;
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
