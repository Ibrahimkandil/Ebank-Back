package com.example.ebank.Services.Mappers.AdminMappers;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})


public abstract class AdminOutputMapper  implements EntityMapper<AdminOutputDto, Admin> {
    public abstract Admin toEntity(AdminOutputDto dto) ;
    public abstract AdminOutputDto toDto(Admin entity) ;

    Admin fromId(Long id) {
        if (id == null) {
            return null;
        }
        Admin admin = new Admin();
        admin.setId(id);
        return admin;
    }

}
