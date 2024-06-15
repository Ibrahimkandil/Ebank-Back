package com.example.ebank.Controllers;

import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllers {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public  String SayHello(){
        return "Hello it's Employee";
    }
    @GetMapping("/all")
    public List<EmployeeOutputDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeOutputDto getEmployeeById(@PathVariable Long id ){
        return this.employeeService.getEmployeeById(id);
    }
}
