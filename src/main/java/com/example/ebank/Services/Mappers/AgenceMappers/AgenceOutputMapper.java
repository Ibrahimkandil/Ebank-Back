package com.example.ebank.Services.Mappers.AgenceMappers;

import com.example.ebank.Entity.Agence;
import com.example.ebank.Services.Dtos.AgenceDto.AgenceOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class AgenceOutputMapper implements EntityMapper<AgenceOutputDto, Agence> {
    public abstract Agence toEntity(AgenceOutputDto dto) ;

    public abstract AgenceOutputDto toDto(Agence entity) ;

    Agence fromId(Long id) {
        if (id == null) {
            return null;
        }
        Agence agence = new Agence();
        agence.setId(id);
        return agence;


    }
}
