package com.example.ebank.Services.Dtos.ClientDtos;

import com.example.ebank.Entity.Employee;
import com.example.ebank.Entity.Reclamation;
import com.example.ebank.Entity.Transaction;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("common-java:DuplicatedBlocks")
public class ClientDto implements Serializable {


    private String last_name;
    private String identificationNumber;
    private String first_name;
    private String Paswword;
    private String Address;
    private String Phone;
    private String Email;
    private String Date_of_birth;

    private String Sexe;
    private ZonedDateTime Date_d_ajout;
    private byte[] image_data;

    private String  etatCivil;

    private String  statutEmploi;

    private Employee addedBy;
    private Reclamation[] reclamations;
    private Transaction[] transactions;

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setPaswword(String paswword) {
        Paswword = paswword;
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

    public void setDate_d_ajout(ZonedDateTime date_d_ajout) {
        Date_d_ajout = date_d_ajout;
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

    public void setAddedBy(Employee addedBy) {
        this.addedBy = addedBy;
    }
    public void setReclamations(Reclamation[] reclamations) {
        this.reclamations = reclamations;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    public void setIdentification_Number(String identification_Number) {
        identificationNumber = identification_Number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getIdentification_Number() {
        return identificationNumber;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPaswword() {
        return Paswword;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getDate_of_birth() {
        return Date_of_birth;
    }

    public String getSexe() {
        return Sexe;
    }

    public ZonedDateTime getDate_d_ajout() {
        return Date_d_ajout;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public String getStatutEmploi() {
        return statutEmploi;
    }


    public Employee getAddedBy() {
        return addedBy;
    }
    public Reclamation[] getReclamations() {
        return reclamations;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(last_name, clientDto.last_name) && Objects.equals(identificationNumber, clientDto.identificationNumber) && Objects.equals(first_name, clientDto.first_name) && Objects.equals(Paswword, clientDto.Paswword) && Objects.equals(Address, clientDto.Address) && Objects.equals(Phone, clientDto.Phone) && Objects.equals(Email, clientDto.Email) && Objects.equals(Date_of_birth, clientDto.Date_of_birth) && Objects.equals(Sexe, clientDto.Sexe) && Objects.equals(Date_d_ajout, clientDto.Date_d_ajout) && Arrays.equals(image_data, clientDto.image_data) && Objects.equals(etatCivil, clientDto.etatCivil) && Objects.equals(statutEmploi, clientDto.statutEmploi) && Objects.equals(addedBy, clientDto.addedBy) && Arrays.equals(reclamations, clientDto.reclamations) && Arrays.equals(transactions, clientDto.transactions);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(last_name, identificationNumber, first_name, Paswword, Address, Phone, Email, Date_of_birth, Sexe, Date_d_ajout, etatCivil, statutEmploi, addedBy);

    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "last_name='" + last_name + '\'' +
                ", Identification_Number='" + identificationNumber + '\'' +
                ", first_name='" + first_name + '\'' +
                ", Paswword='" + Paswword + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Date_of_birth='" + Date_of_birth + '\'' +
                ", Sexe='" + Sexe + '\'' +
                ", Date_d_ajout=" + Date_d_ajout +
                ", etatCivil='" + etatCivil + '\'' +
                ", statutEmploi='" + statutEmploi + '\'' +
                ", addedBy=" + addedBy +
                ", reclamations=" + Arrays.toString(reclamations) +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
