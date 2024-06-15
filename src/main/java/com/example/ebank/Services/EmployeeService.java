package com.example.ebank.Services;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Repository.IEmployeeRepo;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeInputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo iemployeeRepo;
    @Autowired
    private EmployeeOutputMapper employeeOutputMapper;
    @Autowired
    private EmployeeInputMapper employeeInputMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeOutputDto> getAllEmployees() {
        List<Employee> employees = this.iemployeeRepo.findAll();
        return employees.stream()
                .map(employeeOutputMapper::toDto) // Map each Client entity to ClientOutputDto using the mapper
                .collect(Collectors.toList()); // Collect the mapped ClientOutputDto objects into a list
    }



    @Override
    public Employee getEmployee(String identification, String password) {
        return null;
    }

    @Override
    public EmployeeOutputDto getEmployeeById(long id) {

        Employee employee = this.iemployeeRepo.findById(id).get();
        return this.employeeOutputMapper.toDto(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(long id) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeByIdentificationNumber(String id) {
        Employee employee=iemployeeRepo.findByIdentificationNumber(id).get();
        return employee;
    }
}
