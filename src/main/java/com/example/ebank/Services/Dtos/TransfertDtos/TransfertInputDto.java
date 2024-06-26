package com.example.ebank.Services.Dtos.TransfertDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class TransfertInputDto implements Serializable {
    private Long id;
    private double amount;
    private ZonedDateTime Date;
    private Client idCompteSource;
    private Client idCompteDestinations;
    private Compte_Bancaire compte_Bancaire;

    public Compte_Bancaire getCompte_Bancaire() {
        return compte_Bancaire;
    }

    public void setCompte_Bancaire(Compte_Bancaire compte_Bancaire) {
        this.compte_Bancaire = compte_Bancaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ZonedDateTime getDate() {
        return Date;
    }

    public void setDate(ZonedDateTime date) {
        Date = date;
    }

    public Client getIdCompteSource() {
        return idCompteSource;
    }

    public void setIdCompteSource(Client idCompteSource) {
        this.idCompteSource = idCompteSource;
    }

    public Client getIdCompteDestinations() {
        return idCompteDestinations;
    }

    public void setIdCompteDestinations(Client idCompteDestinations) {
        this.idCompteDestinations = idCompteDestinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertInputDto that = (TransfertInputDto) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(Date, that.Date) && Objects.equals(idCompteSource, that.idCompteSource) && Objects.equals(idCompteDestinations, that.idCompteDestinations) && Objects.equals(compte_Bancaire, that.compte_Bancaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, Date, idCompteSource, idCompteDestinations, compte_Bancaire);
    }

    @Override
    public String toString() {
        return "TransfertInputDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", Date=" + Date +
                ", idCompteSource=" + idCompteSource +
                ", idCompteDestinations=" + idCompteDestinations +
                ", compte_Bancaire=" + compte_Bancaire +
                '}';
    }
}
