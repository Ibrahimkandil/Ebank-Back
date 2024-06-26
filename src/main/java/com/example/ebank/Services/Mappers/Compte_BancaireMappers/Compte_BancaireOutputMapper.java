package com.example.ebank.Services.Mappers.Compte_BancaireMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class Compte_BancaireOutputMapper implements EntityMapper<Compte_BancaireOutputDto, Compte_Bancaire> {

    public abstract Compte_Bancaire toEntity(Compte_BancaireOutputDto dto) ;


    public abstract Compte_BancaireOutputDto toDto(Compte_Bancaire entity) ;


    Compte_Bancaire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Compte_Bancaire compteBancaire = new Compte_Bancaire();
        compteBancaire.setId(id);
        return compteBancaire;
    }
}
