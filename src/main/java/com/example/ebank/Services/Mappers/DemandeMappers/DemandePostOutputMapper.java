package com.example.ebank.Services.Mappers.DemandeMappers;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeOutputDto;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandePostOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class DemandePostOutputMapper implements EntityMapper<DemandePostOutputDto, Demande> {




        public abstract Demande toEntity(DemandePostOutputDto dto) ;


        public abstract DemandePostOutputDto toDto(Demande entity);


        Demande fromId(Long id) {
            if (id == null) {
                return null;
            }
            Demande demande = new Demande();
            demande.setId(id);
            return demande;
        }


}
