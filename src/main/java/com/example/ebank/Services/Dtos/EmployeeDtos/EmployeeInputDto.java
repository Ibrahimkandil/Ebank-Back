package com.example.ebank.Services.Dtos.EmployeeDtos;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Agence;
import com.example.ebank.Entity.genre;
import lombok.Getter;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Mapper(componentModel = "spring", uses = {})


public class EmployeeInputDto implements Serializable {


    private String name;
    private String mail;
    private double salaire;
    private String address;
    private String cin;
    private ZonedDateTime Date_ajout;
    private Admin added_by;
    private String last_name;
    private byte[] image_data;
    private Agence agence;
    private genre Sexe;



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

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public ZonedDateTime getDate_ajout() {
        return Date_ajout;
    }

    public void setDate_ajout(ZonedDateTime date_ajout) {
        Date_ajout = date_ajout;
    }

    public Admin getAdded_by() {
        return added_by;
    }

    public void setAdded_by(Admin added_by) {
        this.added_by = added_by;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public genre getSexe() {
        return Sexe;
    }

    public void setSexe(genre sexe) {
        Sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInputDto that = (EmployeeInputDto) o;
        return Double.compare(salaire, that.salaire) == 0 &&  Objects.equals(name, that.name) && Objects.equals(mail, that.mail) && Objects.equals(address, that.address) && Objects.equals(cin, that.cin) && Objects.equals(Date_ajout, that.Date_ajout) && Objects.equals(added_by, that.added_by) && Objects.equals(last_name, that.last_name) && Arrays.equals(image_data, that.image_data) && Objects.equals(agence, that.agence) && Sexe == that.Sexe;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, mail, salaire, address, cin, Date_ajout, added_by, last_name, agence, Sexe);
        result = 31 * result + Arrays.hashCode(image_data);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeInputDto{" +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", salaire=" + salaire +
                ", address='" + address + '\'' +
                ", cin='" + cin + '\'' +
                ", Date_ajout=" + Date_ajout +
                ", added_by=" + added_by +
                ", last_name='" + last_name + '\'' +
                ", agence=" + agence +
                ", Sexe=" + Sexe +
                '}';
    }
}
