package com.example.ebank.Services.Mappers.DemandeMappers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class DemandeMapper implements EntityMapper<DemandeDto, Demande> {

    public abstract Demande toEntity(DemandeDto dto) ;


    public abstract DemandeDto toDto(Demande entity);

    public Demande partialUpdate(Demande entity, Demande dto) {
        if (dto.getClient() != null) {
            entity.setClient(dto.getClient());
        }
        if (dto.getMontant() != 0) {
            entity.setMontant(dto.getMontant());
        }
        if (dto.getType() != null) {
            entity.setType(dto.getType());
        }
        if (dto.getRaisonDemandeCredit() != null) {
            entity.setRaisonDemandeCredit(dto.getRaisonDemandeCredit());
        }

        return entity;

    }
    Demande fromId(Long id) {
        if (id == null) {
            return null;
        }
        Demande demande = new Demande();
        demande.setId(id);
        return demande;
    }
}
