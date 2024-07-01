package com.example.ebank.Services.Mappers.AgenceMappers;

import com.example.ebank.Entity.Agence;
import com.example.ebank.Services.Dtos.AgenceDto.AgenceInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class AgenceInputMapper implements EntityMapper<AgenceInputDto, Agence> {

    public abstract Agence toEntity(AgenceInputDto dto) ;

    public abstract AgenceInputDto toDto(Agence entity) ;

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
}
