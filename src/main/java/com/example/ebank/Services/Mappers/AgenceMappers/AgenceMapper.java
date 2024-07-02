package com.example.ebank.Services.Mappers.AgenceMappers;

import com.example.ebank.Entity.Agence;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Entity.contrat_prete;
import com.example.ebank.Services.Dtos.AgenceDto.AgenceDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import jakarta.persistence.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})

public abstract class AgenceMapper implements EntityMapper<AgenceDto, Agence> {

    public abstract Agence toEntity(AgenceDto dto) ;

    @Override
    public abstract AgenceDto toDto(Agence entity) ;

    public Agence partialUpdate(Agence entity, Agence dto) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getAddress() != null) {
            entity.setAddress(dto.getAddress());
        }
        if (dto.getPhone() != null) {
            entity.setPhone(dto.getPhone());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPostalCode() != null) {
            entity.setPostalCode(dto.getPostalCode());
        }
        if (dto.getCity() != null) {
            entity.setCity(dto.getCity());
        }
        if (dto.getCountry() != null) {
            entity.setCountry(dto.getCountry());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getCode() != null) {
            entity.setCode(dto.getCode());
        }
        if (dto.getCreationDate() != null) {
            entity.setCreationDate(dto.getCreationDate());
        }
        if (dto.getEmployees() != null) {
            entity.setEmployees(dto.getEmployees());
        }
        if (dto.getResponsable() != null) {
            entity.setResponsable(dto.getResponsable());
        }
        if (dto.getBudget() != 0) {
            entity.setBudget(dto.getBudget());
        }


        return entity;

    }
    Agence fromId(Long id) {
        if (id == null) {
            return null;
        }
        Agence agence = new Agence();
        agence.setId(id);
        return agence;


    }
}
