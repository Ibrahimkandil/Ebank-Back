package com.example.ebank.Services.Dtos.EmployeeDtos;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Agence;
import com.example.ebank.Entity.genre;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("common-java:DuplicatedBlocks")
public class EmployeeDto implements Serializable {


    private Long id;

    private String name;
    private String mail;
    private double salaire;
    private String address;
    private String cin;
    private ZonedDateTime Date_ajout;
    private String password;

    private Admin added_by;
    private String last_name;
    private String identification_number;
    private byte[] image_data;
    private Agence agence;

    private genre Sexe;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
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
        EmployeeDto that = (EmployeeDto) o;
        return Double.compare(salaire, that.salaire) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mail, that.mail) && Objects.equals(address, that.address) && Objects.equals(cin, that.cin) && Objects.equals(Date_ajout, that.Date_ajout) && Objects.equals(password, that.password) && Objects.equals(added_by, that.added_by) && Objects.equals(last_name, that.last_name) && Objects.equals(identification_number, that.identification_number) && Arrays.equals(image_data, that.image_data) && Objects.equals(agence, that.agence) && Sexe == that.Sexe;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, mail, salaire, address, cin, Date_ajout, password, added_by, last_name, identification_number, agence, Sexe);
        result = 31 * result + Arrays.hashCode(image_data);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", salaire=" + salaire +
                ", address='" + address + '\'' +
                ", cin='" + cin + '\'' +
                ", Date_ajout=" + Date_ajout +
                ", password='" + password + '\'' +
                ", added_by=" + added_by +
                ", last_name='" + last_name + '\'' +
                ", identification_number='" + identification_number + '\'' +
                ", agence=" + agence +
                ", Sexe=" + Sexe +
                '}';
    }
}
