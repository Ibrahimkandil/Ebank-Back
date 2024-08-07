package com.example.ebank.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compte_Bancaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Numéro_de_compte")
    private String accountNumber;
    @Column(name = "Solde")
    private double balance;
    @Column(name = "Date_d'ouverture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date opening_date;
    @Column(name = "Type_de_compte")
    @Enumerated(EnumType.STRING)
    private Type_Compte account_type;
    @Column(name = "Date_de_fermeture")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date closing_date;
    @Column(name = "Taux_d'intérêt")
    private double interest_rate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
