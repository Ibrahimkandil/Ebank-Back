package com.example.ebank.Services.Dtos.AgenceDto;

import com.example.ebank.Entity.Agence;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;

import java.util.List;

public class AgenceOutputDto {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String postalCode;
    private String city;
    private String country;

    private String description;
    private String code;
    private boolean state;
    private String creationDate;
    private List<EmployeePOSTOutputDto> employees;
    private EmployeePOSTOutputDto responsable;
    private double budget;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<EmployeePOSTOutputDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeePOSTOutputDto> employees) {
        this.employees = employees;
    }

    public EmployeePOSTOutputDto getResponsable() {
        return responsable;
    }

    public void setResponsable(EmployeePOSTOutputDto responsable) {
        this.responsable = responsable;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

}
