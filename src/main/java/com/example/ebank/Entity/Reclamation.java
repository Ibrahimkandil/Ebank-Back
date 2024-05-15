package com.example.ebank.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Sender")
    private Client client;
    @Column(name = "Sujet")
    private String subject;
    @Column(name = "Description")
    private String description;
    @Column(name = "Date")
    private ZonedDateTime date;


}
