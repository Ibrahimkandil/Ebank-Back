package com.example.ebank.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class contrat_prete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="Durée_paiment_en_mois")
    private int duree;
    @Column(name="Date_Debut")
    private ZonedDateTime date_debut;
    @Column(name="Date_Fin")
    private ZonedDateTime date_fin;
    @Column(name="Montant")
    private double montant;
    @Column(name="mensualites")
    private double mensualites;
    @Column(name="FrequencePaiement")
    private frequencePaiement frequencePaiement;
    @Column(name="TypeInteret")
    private String typeInteret;
    @Column(name="typeCredit")
    private String typeCredit;
    @Column(name="FraisDossier")
    private double fraisDossier;
    @Column(name="Etat_Contrat")
    private etatContrat etatContrat;
    @Column(name="informationsAssurance")
    private String informationsAssurance;
    @Column(name="Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "Demande_id")
    private Demande demande;

}
