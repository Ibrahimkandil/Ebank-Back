package com.example.ebank.Services.Mappers.WalletMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Entity.Wallet;
import com.example.ebank.Services.Dtos.WalletDtos.WalletDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import jakarta.persistence.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class WalletDtoMapper implements EntityMapper<WalletDto, Wallet> {
    public abstract Wallet toEntity(WalletDto dto) ;

     public abstract WalletDto toDto(Wallet entity);


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

        return entity;
    }
    Wallet fromId(Long id) {
        if (id == null) {
            return null;
        }
        Wallet Wallet = new Wallet();
        Wallet.setId(id);
        return Wallet;
    }
}
