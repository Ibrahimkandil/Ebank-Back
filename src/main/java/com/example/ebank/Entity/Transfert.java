package com.example.ebank.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transfert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Montant")
    private double amount;
    @Column(name="Date")
    private ZonedDateTime Date;
    @ManyToOne
    @JoinColumn(name = "Compte Source")
    private Client idCompteSource;
    @ManyToOne
    @JoinColumn(name = "Compte Destinataire")
    private Client idCompteDestinations;
}


