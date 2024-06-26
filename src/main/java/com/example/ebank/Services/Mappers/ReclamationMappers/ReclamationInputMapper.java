package com.example.ebank.Services.Mappers.ReclamationMappers;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Services.Dtos.ReclamationDtos.ReclamationInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class ReclamationInputMapper implements EntityMapper<ReclamationInputDto, Reclamation> {
    public abstract Reclamation toEntity(ReclamationInputDto dto) ;


    public abstract ReclamationInputDto toDto(Reclamation entity);

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

}
