package com.example.ebank.Services.Mappers.Compte_BancaireMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class Compte_BancaireInputMapper implements EntityMapper<Compte_BancaireInputDto, Compte_Bancaire> {
    public abstract Compte_Bancaire toEntity(Compte_BancaireInputDto dto) ;


    public abstract Compte_BancaireInputDto toDto(Compte_Bancaire entity) ;
    public Compte_Bancaire partialUpdate(Compte_Bancaire entity, Compte_Bancaire c1) {
        if (c1.getAccount_number() != null) {
            entity.setAccount_number(c1.getAccount_number());
        }
        if (c1.getBalance() != 0) {
            entity.setBalance(c1.getBalance());
        }
        if (c1.getOpening_date() != null) {
            entity.setOpening_date(c1.getOpening_date());
        }
        if (c1.getAccount_type() != null) {
            entity.setAccount_type(c1.getAccount_type());
        }
        if (c1.getClosing_date() != null) {
            entity.setClosing_date(c1.getClosing_date());
        }
        if (c1.getInterest_rate() != 0) {
            entity.setInterest_rate(c1.getInterest_rate());
        }
        if (c1.getDate_d_ajout() != null) {
            entity.setDate_d_ajout(c1.getDate_d_ajout());
        }
        if (c1.getClient() != null) {
            entity.setClient(c1.getClient());
        }
        return entity;

    }
}
