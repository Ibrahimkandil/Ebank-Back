package com.example.ebank.Services.Dtos.EmployeeDtos;

import com.example.ebank.Entity.Agence;
import com.example.ebank.Entity.genre;

import java.util.Objects;

public class EmployeePOSTOutputDto {
    private String name;
    private String mail;
    private String last_name;
    private Agence agence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePOSTOutputDto that = (EmployeePOSTOutputDto) o;
        return Objects.equals(name, that.name) && Objects.equals(mail, that.mail)  && Objects.equals(last_name, that.last_name) && Objects.equals(agence, that.agence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, last_name, agence);
    }

    @Override
    public String toString() {
        return "EmployeePOSTOutputDto{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", last_name='" + last_name + '\'' +
                ", agence=" + agence +
                '}';
    }
}
