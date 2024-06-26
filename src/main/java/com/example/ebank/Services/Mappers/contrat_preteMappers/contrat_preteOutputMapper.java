package com.example.ebank.Services.Mappers.contrat_preteMappers;

import com.example.ebank.Entity.contrat_prete;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class contrat_preteOutputMapper implements EntityMapper<contrat_preteOutputDto, contrat_prete> {

    public abstract contrat_prete toEntity(contrat_preteOutputDto dto) ;


    public abstract contrat_preteOutputDto toDto(contrat_prete entity) ;


    contrat_prete fromId(Long id) {
        if (id == null) {
            return null;
        }
        contrat_prete contrat_prete = new contrat_prete();
        contrat_prete.setId(id);
        return contrat_prete;
    }
}
