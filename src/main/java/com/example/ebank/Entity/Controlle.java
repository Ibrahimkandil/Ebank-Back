package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class Controlle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private long id_User;
    @Enumerated(EnumType.STRING)
    private EtatCompte etatCompte;
    @Column(name = "signature_Confiramation",length = 1048576)
    private byte[] confirmation;
    @Column(name = "signature_Suppression",length = 1048576)
    private byte[] Demande_suppression;
    @Column(name = "Suppression",length = 1048576)
    private byte[] suppresion;
}
