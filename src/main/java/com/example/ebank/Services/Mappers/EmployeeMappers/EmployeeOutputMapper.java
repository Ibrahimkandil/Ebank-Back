package com.example.ebank.Services.Mappers.EmployeeMappers;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})


public abstract class EmployeeOutputMapper implements EntityMapper<EmployeeOutputDto, Employee> {
    public abstract Employee toEntity(EmployeeOutputDto dto) ;
    public abstract EmployeeOutputDto toDto(Employee entity) ;

    Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }

}
