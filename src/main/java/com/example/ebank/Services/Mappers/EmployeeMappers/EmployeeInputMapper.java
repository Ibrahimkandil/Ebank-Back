package com.example.ebank.Services.Mappers.EmployeeMappers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})


public abstract class EmployeeInputMapper implements EntityMapper<EmployeeInputDto, Employee> {

    public abstract Employee toEntity(EmployeeInputDto dto) ;


    public abstract EmployeeInputDto toDto(Employee entity) ;

    public void partialUpdate(Employee entity, EmployeeDto employeeDto) {
        if (employeeDto.getName() != null) {
            entity.setName(employeeDto.getName());
        }

        if (employeeDto.getMail() != null) {
            entity.setMail(employeeDto.getMail());
        }

        if (employeeDto.getSalaire() != 0) {
            entity.setSalaire(employeeDto.getSalaire());
        }

        if (employeeDto.getAddress() != null) {
            entity.setAddress(employeeDto.getAddress());
        }

        if (employeeDto.getCin() != null) {
            entity.setCin(employeeDto.getCin());
        }

        if (employeeDto.getDate_ajout() != null) {
            entity.setDate_ajout(employeeDto.getDate_ajout());
        }

        if (employeeDto.getPassword() != null) {
            entity.setPassword(employeeDto.getPassword());
        }

        if (employeeDto.getAdded_by() != null) {
            entity.setAdded_by(employeeDto.getAdded_by());
        }

        if (employeeDto.getLast_name() != null) {
            entity.setLast_name(employeeDto.getLast_name());
        }

        if (employeeDto.getIdentification_number() != null) {
            entity.setIdentificationNumber(employeeDto.getIdentification_number());
        }

        if (employeeDto.getImage_data() != null) {
            entity.setImage_data(employeeDto.getImage_data());
        }

        if (employeeDto.getAgence() != null) {
            entity.setAgence(employeeDto.getAgence());
        }

        if (employeeDto.getSexe() != null) {
            entity.setSexe(employeeDto.getSexe());
        }

    }





}
