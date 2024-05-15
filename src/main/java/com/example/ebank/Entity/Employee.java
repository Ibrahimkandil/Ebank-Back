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
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "Email")
    private String mail;
    @Column(name = "Salaire")
    private double salaire;
    @Column(name = "Adresse")
    private String address;
    @Column(name = "CIN")
    private String cin;
    @Column(name = "Date_ajout")
    private ZonedDateTime Date_ajout;
    @Column(name = "Mots_de_passe")
    private String password;
    @ManyToOne // Many clients can be added by one employee
    @JoinColumn(name =  "Ajouté_par")
    private Admin added_by;
    @Column(name = "Prénom")
    private String last_name;
    @Column(name = "UserCode")
    private String identification_number;
    @Column(name = "image_data")
    private byte[] image_data;
    @ManyToOne
    private Agence agence;

    public String Genrateur_Motsdupasse(){
        String password = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = (int)(password.length() * Math.random());
            sb.append(password.charAt(index));
        }
        return sb.toString();

    }
    public String Genrateur_Identification() {
        String password = "0123456789";
        StringBuilder sb = new StringBuilder("2");
        for (int i = 0; i <3; i++) {
            int index = (int)(password.length() * Math.random());
            sb.append(password.charAt(index));
        }
        return sb.toString();
    }
}
