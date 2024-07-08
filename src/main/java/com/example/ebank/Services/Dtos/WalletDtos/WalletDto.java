package com.example.ebank.Services.Dtos.WalletDtos;



import java.io.Serializable;
import java.util.Objects;

public class WalletDto implements Serializable {

        private Long id;
        private String currency;
        private String date_modification;
       private Long compte_Id;

        private Long  id_client;
        private double balance;


    public Long getCompte_Id() {
        return compte_Id;
    }

    public void setCompte_Id(Long compte_Id) {
        this.compte_Id = compte_Id;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletDto walletDto = (WalletDto) o;
        return Double.compare(balance, walletDto.balance) == 0 && Objects.equals(id, walletDto.id) && Objects.equals(currency, walletDto.currency) && Objects.equals(date_modification, walletDto.date_modification) && Objects.equals(compte_Id, walletDto.compte_Id) && Objects.equals(id_client, walletDto.id_client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, date_modification, compte_Id, id_client, balance);
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", compte_Id=" + compte_Id +
                ", id_client=" + id_client +
                ", balance=" + balance +
                '}';
    }
}
