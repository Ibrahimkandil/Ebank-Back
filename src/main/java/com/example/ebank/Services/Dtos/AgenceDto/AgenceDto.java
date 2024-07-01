package com.example.ebank.Services.Dtos.AgenceDto;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class AgenceDto  implements Serializable {

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
    private List<Employee> employees;
    private Employee responsable;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getResponsable() {
        return responsable;
    }

    public void setResponsable(Employee responsable) {
        this.responsable = responsable;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenceDto agenceDto = (AgenceDto) o;
        return state == agenceDto.state && Double.compare(budget, agenceDto.budget) == 0 && Objects.equals(id, agenceDto.id) && Objects.equals(name, agenceDto.name) && Objects.equals(address, agenceDto.address) && Objects.equals(phone, agenceDto.phone) && Objects.equals(email, agenceDto.email) && Objects.equals(postalCode, agenceDto.postalCode) && Objects.equals(city, agenceDto.city) && Objects.equals(country, agenceDto.country) && Objects.equals(description, agenceDto.description) && Objects.equals(code, agenceDto.code) && Objects.equals(creationDate, agenceDto.creationDate) && Objects.equals(employees, agenceDto.employees) && Objects.equals(responsable, agenceDto.responsable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, email, postalCode, city, country, description, code, state, creationDate, employees, responsable, budget);
    }

    @Override
    public String toString() {
        return "AgenceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", state=" + state +
                ", creationDate='" + creationDate + '\'' +
                ", employees=" + employees +
                ", responsable=" + responsable +
                ", budget=" + budget +
                '}';
    }
}
