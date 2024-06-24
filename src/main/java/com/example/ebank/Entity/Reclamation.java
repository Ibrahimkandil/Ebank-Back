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


public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ComplainantName")
    private Client ComplainantName;
    @Column(name = "Subject")
    private String Subject;
    @Column(name = "Description")
    private String Description;
    @Column(name = "Date")
    private ZonedDateTime Date;
    @Column(name = "Email")
    private String Email;
    @Column(name = "PhoneNumber")
    private String PhoneNumber;



}