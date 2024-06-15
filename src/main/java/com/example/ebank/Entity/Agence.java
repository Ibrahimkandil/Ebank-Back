package com.example.ebank.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "Nom")
    private String name;
    @Column(name = "Adresse")
    private String address;
    @Column(name = "Telephone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Code_Postal")
    private String postalCode;
    @Column(name = "Ville")
    private String city;
    @Column(name = "Pays")
    private String country;

    @Column(name = "Description")
    private String description;
    @Column(name = "Code_Agence")
    private String code;
    @Column(name = "Etat")
    private boolean state;
    @Column(name = "Date_Creation")
    private String creationDate;
    @OneToMany(mappedBy = "agence")
    private List<Employee> employees;
    @OneToOne
    @JoinColumn(name = "Responsable")
    private Employee responsable;
    @Column(name = "Budget")
    private double budget;


}
