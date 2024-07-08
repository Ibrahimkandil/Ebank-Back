package com.example.ebank.Services.Mappers.WalletMappers;

import com.example.ebank.Entity.Wallet;
import com.example.ebank.Services.Dtos.WalletDtos.WalletInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class WalletInputMapper implements EntityMapper<WalletInputDto, Wallet> {
    public abstract Wallet toEntity(WalletInputDto dto) ;

    public abstract WalletInputDto toDto(Wallet entity) ;

    public Wallet partialUpdate(Wallet entity, Wallet dto) {
        if (dto.getClient() != null) {
            entity.setClient(dto.getClient());
        }
        if (dto.getCurrency() != null) {
            entity.setCurrency(dto.getCurrency());
        }
        if (dto.getDate_modification() != null) {
            entity.setDate_modification(dto.getDate_modification());
        }
        if (dto.getBalance() != 0) {
            entity.setBalance(dto.getBalance());
        }
        if(dto.getCompteBancaire()!=null) {
            entity.setCompteBancaire(dto.getCompteBancaire());

        }

        return entity;
    }

}
