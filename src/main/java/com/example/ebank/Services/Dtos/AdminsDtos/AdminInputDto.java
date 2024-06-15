package com.example.ebank.Services.Dtos.AdminsDtos;

import lombok.Getter;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Mapper(componentModel = "spring", uses = {})


public class AdminInputDto implements Serializable {


    private String name;
    private String password;
    private String last_name;
    private String mail;
    private byte[] image_data;
    private String Sexe;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminInputDto that = (AdminInputDto) o;
        return Objects.equals(name, that.name) && Objects.equals(password, that.password) && Objects.equals(last_name, that.last_name) && Objects.equals(mail, that.mail) && Arrays.equals(image_data, that.image_data) && Objects.equals(Sexe, that.Sexe);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, password, last_name, mail, Sexe);
        result = 31 * result + Arrays.hashCode(image_data);
        return result;
    }

    @Override
    public String toString() {
        return "AdminInputDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mail='" + mail + '\'' +
                ", Sexe='" + Sexe + '\'' +
                '}';
    }
}
