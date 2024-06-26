package com.example.ebank.Services.Mappers.TransactionMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.Transaction;
import com.example.ebank.Entity.type_transaction;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancaireDto;
import com.example.ebank.Services.Dtos.TransactionDtos.TransactionInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", uses = {})

public  abstract class TransactionInputMapper implements EntityMapper<TransactionInputDto, Transaction> {
    public abstract Transaction toEntity(TransactionInputDto dto) ;

    public abstract TransactionInputDto toDto(Transaction entity) ;

     Transaction partialUpdate(Transaction entity, Transaction c1) {


        if (c1.getAmount() != 0) {
            entity.setAmount(c1.getAmount());
        }
        if (c1.getType() != null) {
            entity.setType(c1.getType());
        }
        if (c1.getDate_Expiration() != null) {
            entity.setDate_Expiration(c1.getDate_Expiration());
        }
        if (c1.getClient() != null) {
            entity.setClient(c1.getClient());
        }
         if (c1.getCompte_Bancaire() != null) {
             entity.setCompte_Bancaire(c1.getCompte_Bancaire());
         }

        return entity;

    }

    Transaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }
}
