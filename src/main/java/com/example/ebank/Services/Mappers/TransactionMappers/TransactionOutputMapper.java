package com.example.ebank.Services.Mappers.TransactionMappers;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Entity.Transaction;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Dtos.TransactionDtos.TransactionOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class TransactionOutputMapper  implements EntityMapper<TransactionOutputDto, Transaction> {

    public abstract Transaction toEntity(TransactionOutputDto dto) ;

    public abstract TransactionOutputDto toDto(Transaction entity) ;

    Transaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }
}
