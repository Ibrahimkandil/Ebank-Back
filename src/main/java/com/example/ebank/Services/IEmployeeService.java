package com.example.ebank.Services;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeOutputDto> getAllEmployees();
    public Employee getEmployee(String identification, String password);
    public EmployeeOutputDto getEmployeeById(long id);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public void deleteEmployee(Employee employee);
    public Employee getEmployeeByIdentificationNumber(String id);
}
