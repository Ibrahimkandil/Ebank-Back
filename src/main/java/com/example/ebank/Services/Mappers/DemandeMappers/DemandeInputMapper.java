package com.example.ebank.Services.Mappers.DemandeMappers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class DemandeInputMapper implements EntityMapper<DemandeInputDto, Demande> {

    public abstract Demande toEntity(DemandeInputDto dto);


    public abstract DemandeInputDto toDto(Demande entity);

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

}
