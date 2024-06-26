package com.example.ebank.Services.Dtos.TransactionDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.type_transaction;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancairePostOutDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class TransactionOutputDto  implements Serializable {
    private Long id;
    private double amount;
    private type_transaction type;
    private ZonedDateTime Date_Expiration;
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

    public type_transaction getType() {
        return type;
    }

    public void setType(type_transaction type) {
        this.type = type;
    }

    public ZonedDateTime getDate_Expiration() {
        return Date_Expiration;
    }

    public void setDate_Expiration(ZonedDateTime date_Expiration) {
        Date_Expiration = date_Expiration;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionOutputDto that = (TransactionOutputDto) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && type == that.type && Objects.equals(Date_Expiration, that.Date_Expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, type, Date_Expiration);
    }

    @Override
    public String toString() {
        return "TransactionOutputDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", type=" + type +
                ", Date_Expiration=" + Date_Expiration +
                '}';
    }
}
