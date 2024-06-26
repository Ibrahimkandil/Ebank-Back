package com.example.ebank.Services.Mappers.ReclamationMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Services.Dtos.ReclamationDtos.ReclamationDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", uses = {})

public abstract class ReclamationMapper implements EntityMapper<ReclamationDto, Reclamation> {
    public abstract Reclamation toEntity(ReclamationDto dto);

    public abstract ReclamationDto toDto(Reclamation entity) ;


    public Reclamation partialUpdate(Reclamation entity, Reclamation dto) {
        if (dto.getClient() != null) {
            entity.setClient(dto.getClient());
        }
        if (dto.getSubject() != null) {
            entity.setSubject(dto.getSubject());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getDate() != null) {
            entity.setDate(dto.getDate());
        }

        return entity;
    }
    Reclamation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reclamation Reclamation = new Reclamation();
        Reclamation.setId(id);
        return Reclamation;
    }
}
