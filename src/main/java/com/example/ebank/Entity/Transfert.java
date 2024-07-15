package com.example.ebank.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date Date;
    @ManyToOne
    @JoinColumn(name = "Compte Source")
    private Client idCompteSource;
    @ManyToOne
    @JoinColumn(name = "Compte Destinataire")
    private Client idCompteDestinations;
}


