package com.example.ebank.Services.Dtos.WalletDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;

import java.io.Serializable;
import java.util.Objects;

public class WalletOutputDto {


        private Long id;
        private String currency;
        private String date_modification;

    private ClientPostOutputDto client;
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

    public ClientPostOutputDto getClient() {
        return client;
    }

    public void setClient(ClientPostOutputDto client) {
        this.client = client;
    }

    public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof WalletOutputDto that)) return false;
        return Double.compare(getBalance(), that.getBalance()) == 0 && Objects.equals(getId(), that.getId()) && Objects.equals(getCurrency(), that.getCurrency()) && Objects.equals(getDate_modification(), that.getDate_modification()) && Objects.equals(getClient(), that.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCurrency(), getDate_modification(), getClient(), getBalance());
    }

    @Override
    public String toString() {
        return "WalletOutputDto{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", client=" + client +
                ", balance=" + balance +
                '}';
    }
}


