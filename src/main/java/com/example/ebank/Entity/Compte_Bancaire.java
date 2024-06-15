package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Compte_Bancaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Numéro_de_compte")
    private String account_number;
    @Column(name = "Solde")
    private double balance;
    @Column(name = "Date_d'ouverture")
    private ZonedDateTime opening_date;
    @Column(name = "Type_de_compte")
    @Enumerated(EnumType.STRING)
    private Type_Compte account_type;
    @Column(name = "Date_de_fermeture")
    private String closing_date;
    @Column(name = "Taux_d'intérêt")
    private double interest_rate;
    @Column(name = "Date_d'ajout")
    private ZonedDateTime Date_d_ajout;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}
