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
    private ZonedDateTime Date_Expiration;
}
