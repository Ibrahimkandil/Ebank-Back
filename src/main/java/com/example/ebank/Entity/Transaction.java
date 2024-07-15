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
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Montant")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "Type")
    @Enumerated(EnumType.STRING)
    private type_transaction type;
    @Column(name = "Date_Expiration")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date Date_Expiration;
    /*
    @ManyToOne
    private Compte_Bancaire compte_Bancaire;
     */
}
