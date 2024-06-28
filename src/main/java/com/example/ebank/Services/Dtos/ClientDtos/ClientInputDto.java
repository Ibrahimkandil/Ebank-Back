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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate_of_birth() {
        return Date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getStatutEmploi() {
        return statutEmploi;
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
        int result = Objects.hash(last_name, first_name, Address, Phone, Email, Date_of_birth, Sexe, etatCivil, statutEmploi);
        result = 31 * result + Arrays.hashCode(image_data);
        return result;
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
                ", image_data=" + Arrays.toString(image_data) +
                ", etatCivil='" + etatCivil + '\'' +
                ", statutEmploi='" + statutEmploi + '\'' +
                '}';
    }
}
