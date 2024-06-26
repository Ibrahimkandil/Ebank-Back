package com.example.ebank.Services.Dtos.Comptes_BancaireDtos;

import java.util.Objects;

public class Compte_BancairePostOutDto {
    private Long id;
    private String account_number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte_BancairePostOutDto that = (Compte_BancairePostOutDto) o;
        return Objects.equals(id, that.id) && Objects.equals(account_number, that.account_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account_number);
    }

    @Override
    public String toString() {
        return "Compte_BancairePostOutDto{" +
                "id=" + id +
                ", account_number='" + account_number + '\'' +
                '}';
    }
}
