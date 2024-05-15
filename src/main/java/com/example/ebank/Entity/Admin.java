package com.example.ebank.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "UserCode")
    private String identification_number;
    @Column(name = "Mots_de_passe")
    private String password;
    @Column(name = "Prénom")
    private String last_name;
    @Column(name = "Email")
    private String mail;
    @Column(name = "image_data")
    private byte[] image_data;
}
