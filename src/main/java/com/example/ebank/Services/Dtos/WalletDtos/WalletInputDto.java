package com.example.ebank.Services.Dtos.WalletDtos;

import java.io.Serializable;
import java.util.Objects;

public class WalletInputDto implements Serializable {
    private String currency;
    private String date_modification;

    private Long  id_client;
    private Long compte_Id;
    private double balance;
    private double rate;


    public Long getCompte_Id() {
        return compte_Id;
    }

    public void setCompte_Id(Long compte_Id) {
        this.compte_Id = compte_Id;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletInputDto that = (WalletInputDto) o;
        return Double.compare(balance, that.balance) == 0 && Double.compare(rate, that.rate) == 0 && Objects.equals(currency, that.currency) && Objects.equals(date_modification, that.date_modification) && Objects.equals(id_client, that.id_client) && Objects.equals(compte_Id, that.compte_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, date_modification, id_client, compte_Id, balance, rate);
    }

    @Override
    public String toString() {
        return "WalletInputDto{" +
                "currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", id_client=" + id_client +
                ", compte_Id=" + compte_Id +
                ", balance=" + balance +
                ", rate=" + rate +
                '}';
    }
}
