package com.example.ebank.Services.Mappers.EmployeeMappers;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class EmployeePOSTOutputMapper implements EntityMapper<EmployeePOSTOutputDto, Employee> {
public abstract Employee toEntity(EmployeePOSTOutputDto dto) ;
public abstract EmployeePOSTOutputDto toDto(Employee entity) ;
    // Mapping method to convert from Long to Client
//    @Mapping(target = "addedBy", source = "addedById") // Assuming "addedById" is the correct property name in your DTO
//    public abstract Client map(Long value);

    Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }

}
