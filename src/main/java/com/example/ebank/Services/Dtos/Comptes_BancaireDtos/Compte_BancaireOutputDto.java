package com.example.ebank.Services.Dtos.Comptes_BancaireDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Type_Compte;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Compte_BancaireOutputDto implements Serializable {
    private Long id;
    private String accountNumber;
    private double balance;
    private ZonedDateTime opening_date;
    private Type_Compte account_type;
    private String closing_date;
    private double interest_rate;
    private ZonedDateTime Date_d_ajout;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ZonedDateTime getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(ZonedDateTime opening_date) {
        this.opening_date = opening_date;
    }

    public Type_Compte getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Type_Compte account_type) {
        this.account_type = account_type;
    }

    public String getClosing_date() {
        return closing_date;
    }

    public void setClosing_date(String closing_date) {
        this.closing_date = closing_date;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public ZonedDateTime getDate_d_ajout() {
        return Date_d_ajout;
    }

    public void setDate_d_ajout(ZonedDateTime date_d_ajout) {
        Date_d_ajout = date_d_ajout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte_BancaireOutputDto that = (Compte_BancaireOutputDto) o;
        return Double.compare(balance, that.balance) == 0 && Double.compare(interest_rate, that.interest_rate) == 0 && Objects.equals(id, that.id) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(opening_date, that.opening_date) && account_type == that.account_type && Objects.equals(closing_date, that.closing_date) && Objects.equals(Date_d_ajout, that.Date_d_ajout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, balance, opening_date, account_type, closing_date, interest_rate, Date_d_ajout);
    }

    @Override
    public String toString() {
        return "Compte_BancaireOutputDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", opening_date=" + opening_date +
                ", account_type=" + account_type +
                ", closing_date='" + closing_date + '\'' +
                ", interest_rate=" + interest_rate +
                ", Date_d_ajout=" + Date_d_ajout +
                '}';
    }
}
