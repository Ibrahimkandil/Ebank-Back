package com.example.ebank.Services.Dtos.AdminsDtos;

import java.util.Objects;

public class AdminPOSTOutputDto {
    private String name;
    private String last_name;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminPOSTOutputDto that = (AdminPOSTOutputDto) o;
        return Objects.equals(name, that.name) && Objects.equals(last_name, that.last_name) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, last_name, mail);
    }

    @Override
    public String toString() {
        return "AdminPOSTOutputDto{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
