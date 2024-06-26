package com.example.ebank.Services.Mappers.TransfertMappers;

import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Services.Dtos.TransfertDtos.TransfertOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class TransfertOutputMapper implements EntityMapper<TransfertOutputDto, Transfert> {
    @Override
    public abstract Transfert toEntity(TransfertOutputDto dto);
    @Override
    public abstract TransfertOutputDto toDto(Transfert entity);

    Transfert fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transfert transfert = new Transfert();
        transfert.setId(id);
        return transfert;
    }
}
