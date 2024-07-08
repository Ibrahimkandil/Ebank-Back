package com.example.ebank.Services.Dtos.WalletDtos;


import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;
import com.example.ebank.Services.Dtos.Comptes_BancaireDtos.Compte_BancairePostOutDto;

import java.io.Serializable;
import java.util.Objects;

public class WalletOutputDto implements Serializable {


        private Long id;
        private String currency;
        private String date_modification;
        private Compte_BancairePostOutDto compteBancaire;

        private ClientPostOutputDto client;
        private double balance;

    public Compte_BancairePostOutDto getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(Compte_BancairePostOutDto compteBancaire) {
        this.compteBancaire = compteBancaire;
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
        if (o == null || getClass() != o.getClass()) return false;
        WalletOutputDto that = (WalletOutputDto) o;
        return Double.compare(balance, that.balance) == 0 && Objects.equals(id, that.id) && Objects.equals(currency, that.currency) && Objects.equals(date_modification, that.date_modification) && Objects.equals(compteBancaire, that.compteBancaire) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, date_modification, compteBancaire, client, balance);
    }

    @Override
    public String toString() {
        return "WalletOutputDto{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", date_modification='" + date_modification + '\'' +
                ", compteBancaire=" + compteBancaire +
                ", client=" + client +
                ", balance=" + balance +
                '}';
    }
}


