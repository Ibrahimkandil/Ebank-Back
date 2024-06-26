package com.example.ebank.Services.Dtos.TransactionDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Compte_Bancaire;
import com.example.ebank.Entity.type_transaction;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class TransactionDto implements Serializable {
    private Long id;
    private double amount;
    private Client client;
    private type_transaction type;
    private ZonedDateTime Date_Expiration;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        TransactionDto that = (TransactionDto) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(id, that.id) && Objects.equals(client, that.client) && type == that.type && Objects.equals(Date_Expiration, that.Date_Expiration) && Objects.equals(compte_Bancaire, that.compte_Bancaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, client, type, Date_Expiration, compte_Bancaire);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", client=" + client +
                ", type=" + type +
                ", Date_Expiration=" + Date_Expiration +
                ", compte_Bancaire=" + compte_Bancaire +
                '}';
    }
}
