package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency")
    private String currency;
    @Column(name="date_modification")
    private String date_modification;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name="balance")
    private double balance;


}
