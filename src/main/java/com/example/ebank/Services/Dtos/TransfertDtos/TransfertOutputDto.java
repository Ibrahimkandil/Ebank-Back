package com.example.ebank.Services.Dtos.TransfertDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancairePostOutDto;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;
import java.util.Objects;

public class TransfertOutputDto {

    private Long id;
    private double amount;
    private ZonedDateTime Date;
        private ClientPostOutputDto idCompteSource;
    private ClientPostOutputDto idCompteDestinations;
    private Compte_BancairePostOutDto compte_Bancaire;

    public Compte_BancairePostOutDto getCompte_Bancaire() {
        return compte_Bancaire;
    }

    public void setCompte_Bancaire(Compte_BancairePostOutDto compte_Bancaire) {
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

    public ClientPostOutputDto getIdCompteSource() {
        return idCompteSource;
    }

    public void setIdCompteSource(ClientPostOutputDto idCompteSource) {
        this.idCompteSource = idCompteSource;
    }

    public ClientPostOutputDto getIdCompteDestinations() {
        return idCompteDestinations;
    }

    public void setIdCompteDestinations(ClientPostOutputDto idCompteDestinations) {
        this.idCompteDestinations = idCompteDestinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransfertOutputDto that = (TransfertOutputDto) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(Date, that.Date) && Objects.equals(idCompteSource, that.idCompteSource) && Objects.equals(idCompteDestinations, that.idCompteDestinations) && Objects.equals(compte_Bancaire, that.compte_Bancaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, Date, idCompteSource, idCompteDestinations, compte_Bancaire);
    }

    @Override
    public String toString() {
        return "TransfertOutputDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", Date=" + Date +
                ", idCompteSource=" + idCompteSource +
                ", idCompteDestinations=" + idCompteDestinations +
                ", compte_Bancaire=" + compte_Bancaire +
                '}';
    }
}

