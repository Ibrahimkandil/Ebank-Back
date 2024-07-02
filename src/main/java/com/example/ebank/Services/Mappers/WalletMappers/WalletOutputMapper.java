package com.example.ebank.Services.Mappers.WalletMappers;

import com.example.ebank.Entity.Wallet;
import com.example.ebank.Services.Dtos.WalletDtos.WalletOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class WalletOutputMapper implements EntityMapper<WalletOutputDto, Wallet> {
    public abstract Wallet toEntity(WalletOutputDto dto) ;

    public abstract WalletOutputDto toDto(Wallet entity) ;

    Wallet fromId(Long id) {
        if (id == null) {
            return null;
        }
        Wallet Wallet = new Wallet();
        Wallet.setId(id);
        return Wallet;
    }
}
