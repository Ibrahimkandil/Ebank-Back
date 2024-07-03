package com.example.ebank.Services.Dtos.WalletDtos;

import com.example.ebank.Entity.Client;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class WalletDto implements Serializable {

        private Long id;
        private String currency;
        private String date_modification;

        private Long  id_client;
        private double balance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(String date_modification) {
        this.date_modification = date_modification;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", id_client=" + id_client +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WalletDto walletDto)) return false;
        return Double.compare(getBalance(), walletDto.getBalance()) == 0 && Objects.equals(getId(), walletDto.getId()) && Objects.equals(getCurrency(), walletDto.getCurrency()) && Objects.equals(getDate_modification(), walletDto.getDate_modification()) && Objects.equals(getId_client(), walletDto.getId_client());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCurrency(), getDate_modification(), getId_client(), getBalance());
    }
}
