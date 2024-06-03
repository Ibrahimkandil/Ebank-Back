package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

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
    private type_transaction type;
    @Column(name = "Date_Expiration")
    private ZonedDateTime Date_Expiration;
}
