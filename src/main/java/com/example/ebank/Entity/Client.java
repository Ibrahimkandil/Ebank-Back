package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Client implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserCode")
    private String Identification_Number;
    @Column(name="Nom")
    private String lasr_name;
    @Column(name="Prénom")
    private String first_name;
    @Column(name="Mots_de_passe")
    private String Paswword;
    @Column(name="Adresse")
    private String Address;
    @Column(name="Téléphone")
    private String Phone;
    @Column(name="Email")
    private String Email;
    @Column(name="Date_de_naissance")
    private String Date_of_birth;
    @Column(name="Sexe")
    private genre Sexe;
    @Column(name="date_d'ajout")
    private ZonedDateTime Date_d_ajout;
    @Column(name = "image_data")
    private byte[] image_data;
    @Column(name="etatCivil")
    private etatCivil etatCivil;
    @Column(name="status_Emploi")
    private statutEmploi statutEmploi;
    @ManyToOne // Many clients can be added by one employee
    @JoinColumn(name = "employee_id") // This will create a column in the Client table named employee_id to store the foreign key
    private Employee addedBy;
    @OneToMany(mappedBy = "client")
    private List<Reclamation> reclamations;
    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions;

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