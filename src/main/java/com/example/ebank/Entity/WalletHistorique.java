package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
public class WalletHistorique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Montant")
    private double amount;
    @Column(name = "compte_Bancaire")
    private Long Compte_Bancaire_Id;
    @Column(name = "Currency")
    private String Currency;
    @Column(name = "type")
    private typeWallet typeWallet;
    @Column(name = "Date_Creation")
    private ZonedDateTime Date_Creation;

}

