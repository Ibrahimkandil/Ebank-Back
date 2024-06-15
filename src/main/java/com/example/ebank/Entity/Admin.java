package com.example.ebank.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Data
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom")
    private String name;
    @Column(name = "UserCode")
    private String IdentificationNumber;
    @Column(name = "Mots_de_passe")
    private String password;
    @Column(name = "Prénom")
    private String last_name;
    @Column(name = "Email")
    private String mail;
    @Column(name = "image_data")
    private byte[] image_data;
    @Column(name="Sexe")
    @Enumerated(EnumType.STRING)
    private genre Sexe;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
