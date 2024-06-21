package com.example.ebank.Services.Dtos.ClientDtos;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Entity.Transaction;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;
import lombok.Getter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;

@Getter
public class ClientOutputDto implements Serializable {
    private Long id;
    private String last_name;
    private String first_name;
    private String Address;
    private String Phone;
    private String Email;
    private String Date_of_birth;
    private String Sexe;
    private ZonedDateTime Date_d_ajout;
    private byte[] image_data;
    private String  etatCivil;
    private String  statutEmploi;
    private EmployeePOSTOutputDto addedBy;
    private Reclamation[] reclamations;
    private Transaction[] transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ZonedDateTime getDate_d_ajout() {
        return Date_d_ajout;
    }

    public void setDate_d_ajout(ZonedDateTime date_d_ajout) {
        Date_d_ajout = date_d_ajout;
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

    public EmployeePOSTOutputDto getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(EmployeePOSTOutputDto addedBy) {
        this.addedBy = addedBy;
    }

    public Reclamation[] getReclamations() {
        return reclamations;
    }

    public void setReclamations(Reclamation[] reclamations) {
        this.reclamations = reclamations;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOutputDto that = (ClientOutputDto) o;
        return Objects.equals(id, that.id) && Objects.equals(last_name, that.last_name) && Objects.equals(first_name, that.first_name) && Objects.equals(Address, that.Address) && Objects.equals(Phone, that.Phone) && Objects.equals(Email, that.Email) && Objects.equals(Date_of_birth, that.Date_of_birth) && Objects.equals(Sexe, that.Sexe) && Objects.equals(Date_d_ajout, that.Date_d_ajout) && Arrays.equals(image_data, that.image_data) && Objects.equals(etatCivil, that.etatCivil) && Objects.equals(statutEmploi, that.statutEmploi) && Objects.equals(addedBy, that.addedBy) && Arrays.equals(reclamations, that.reclamations) && Arrays.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, last_name, first_name, Address, Phone, Email, Date_of_birth, Sexe, Date_d_ajout, etatCivil, statutEmploi, addedBy);
        result = 31 * result + Arrays.hashCode(image_data);
        result = 31 * result + Arrays.hashCode(reclamations);
        result = 31 * result + Arrays.hashCode(transactions);
        return result;
    }

    @Override
    public String toString() {
        return "ClientOutputDto{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Date_of_birth='" + Date_of_birth + '\'' +
                ", Sexe='" + Sexe + '\'' +
                ", Date_d_ajout=" + Date_d_ajout +
                ", image_data=" + Arrays.toString(image_data) +
                ", etatCivil='" + etatCivil + '\'' +
                ", statutEmploi='" + statutEmploi + '\'' +
                ", addedBy=" + addedBy +
                ", reclamations=" + Arrays.toString(reclamations) +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}


