package com.example.ebank.Services.Mappers.AdminMappers;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public abstract class AdminMapper implements EntityMapper<AdminDto, Admin> {

    public abstract AdminDto toDto(Admin admin);

    public abstract Admin toEntity(AdminDto clientDto);
    public Admin partialUpdate(Admin entity,Admin c1) {
        if (c1.getLast_name() != null) {
            entity.setLast_name(c1.getLast_name());
        }
        if (c1.getIdentificationNumber() != null) {
            entity.setIdentificationNumber(c1.getIdentificationNumber());
        }
        if (c1.getPassword() != null) {
            entity.setPassword(c1.getPassword());
        }
        if (c1.getLast_name() != null) {
            entity.setLast_name(c1.getLast_name());
        }
        if (c1.getMail() != null) {
            entity.setMail(c1.getMail());
        }
        if (c1.getImage_data() != null) {
            entity.setImage_data(c1.getImage_data());
        }
        if (c1.getSexe() != null) {
            entity.setSexe(c1.getSexe());
        }
        return entity;
    }


    // Mapping method to convert from Long to Client
//    @Mapping(target = "addedBy", source = "addedById") // Assuming "addedById" is the correct property name in your DTO
//    public abstract Client map(Long value);

    Client fromId(Long id) {
        if (id == null) {
            return null;
        }
        Client client = new Client();
        client.setId(id);
        return client;
    }
}
