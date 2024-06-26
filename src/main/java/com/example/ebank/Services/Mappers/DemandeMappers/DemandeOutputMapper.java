package com.example.ebank.Services.Mappers.DemandeMappers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class DemandeOutputMapper implements EntityMapper<DemandeOutputDto, Demande> {
    public abstract Demande toEntity(DemandeOutputDto dto) ;


    public abstract DemandeOutputDto toDto(Demande entity);


    Demande fromId(Long id) {
        if (id == null) {
            return null;
        }
        Demande demande = new Demande();
        demande.setId(id);
        return demande;
    }
}
