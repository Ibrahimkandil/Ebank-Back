package com.example.ebank.Services.Dtos.ClientDtos;

import lombok.Getter;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Mapper(componentModel = "spring", uses = {})


public class ClientInputDto implements Serializable {


    private String last_name;
    private String first_name;

    private String Address;
    private String Phone;
    private String Email;
    private String Date_of_birth;
    private String Sexe;
    private byte[] image_data;
    private String  etatCivil;
    private String  statutEmploi;

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setDate_of_birth(String date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public void setStatutEmploi(String statutEmploi) {
        this.statutEmploi = statutEmploi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInputDto that = (ClientInputDto) o;
        return Objects.equals(last_name, that.last_name) && Objects.equals(first_name, that.first_name) && Objects.equals(Address, that.Address) && Objects.equals(Phone, that.Phone) && Objects.equals(Email, that.Email) && Objects.equals(Date_of_birth, that.Date_of_birth) && Objects.equals(Sexe, that.Sexe) && Arrays.equals(image_data, that.image_data) && Objects.equals(etatCivil, that.etatCivil) && Objects.equals(statutEmploi, that.statutEmploi);
    }

    @Override
    public int hashCode() {
        return   Objects.hash(last_name, first_name, Address, Phone, Email, Date_of_birth, Sexe, etatCivil, statutEmploi);

    }

    @Override
    public String toString() {
        return "ClientInputDto{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Date_of_birth='" + Date_of_birth + '\'' +
                ", Sexe='" + Sexe + '\'' +
                ", etatCivil='" + etatCivil + '\'' +
                ", statutEmploi='" + statutEmploi + '\'' +
                '}';
    }
}
