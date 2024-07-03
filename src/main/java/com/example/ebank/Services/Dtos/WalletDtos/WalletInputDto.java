package com.example.ebank.Services.Dtos.WalletDtos;

import java.io.Serializable;
import java.util.Objects;

public class WalletInputDto implements Serializable {
    private String currency;
    private String date_modification;

    private Long  id_client;
    private double balance;



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
        return "WalletInputDto{" +
                ", currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", id_client=" + id_client +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WalletInputDto that)) return false;
        return Double.compare(getBalance(), that.getBalance()) == 0 && Objects.equals(getCurrency(), that.getCurrency()) && Objects.equals(getDate_modification(), that.getDate_modification()) && Objects.equals(getId_client(), that.getId_client());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getCurrency(), getDate_modification(), getId_client(), getBalance());
    }
}
