package com.example.ebank.Services.Mappers.ReclamationMappers;

import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Services.Dtos.ReclamationDtos.ReclamationOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class ReclamationOutputMapper implements EntityMapper<ReclamationOutputDto, Reclamation> {
    public abstract Reclamation toEntity(ReclamationOutputDto dto) ;

    public abstract ReclamationOutputDto toDto(Reclamation entity);

    Reclamation fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reclamation Reclamation = new Reclamation();
        Reclamation.setId(id);
        return Reclamation;
    }
}
