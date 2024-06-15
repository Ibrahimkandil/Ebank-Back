package com.example.ebank.Services.Dtos.AdminsDtos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("common-java:DuplicatedBlocks")
public class AdminDto implements Serializable {

    private Long id;
    private String name;
    private String IdentificationNumber;
    private String password;
    private String last_name;
    private String mail;
    private byte[] image_data;
    private String Sexe;


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

    public String getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        IdentificationNumber = identificationNumber;
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
        AdminDto adminDto = (AdminDto) o;
        return Objects.equals(id, adminDto.id) && Objects.equals(name, adminDto.name) && Objects.equals(IdentificationNumber, adminDto.IdentificationNumber) && Objects.equals(password, adminDto.password) && Objects.equals(last_name, adminDto.last_name) && Objects.equals(mail, adminDto.mail) && Arrays.equals(image_data, adminDto.image_data) && Objects.equals(Sexe, adminDto.Sexe);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, IdentificationNumber, password, last_name, mail, Sexe);
        result = 31 * result + Arrays.hashCode(image_data);
        return result;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", IdentificationNumber='" + IdentificationNumber + '\'' +
                ", password='" + password + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mail='" + mail + '\'' +
                ", Sexe='" + Sexe + '\'' +
                '}';
    }
}
