package com.example.ebank.Services.Mappers.Compte_BancaireMappers;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancairePostOutDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class Compte_BancairePostOutMapper implements EntityMapper<Compte_BancairePostOutDto, Compte_Bancaire> {
        public abstract Compte_Bancaire toEntity(Compte_BancairePostOutDto dto) ;


        public abstract Compte_BancairePostOutDto toDto(Compte_Bancaire entity) ;


        Compte_Bancaire fromId(Long id) {
            if (id == null) {
                return null;
            }
            Compte_Bancaire compteBancaire = new Compte_Bancaire();
            compteBancaire.setId(id);
            return compteBancaire;
        }
}
