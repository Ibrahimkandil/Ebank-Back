package com.example.ebank.Entity;


import jakarta.persistence.*;

import lombok.*;


import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "Client")
    private Client client;
    @Column(name="montant_Demandee")
    private double montant;
    @Column(name="type_credit")
    private type_credit type;

    @Column(name="raisonDemandeCredit")
    private String raisonDemandeCredit;


}
