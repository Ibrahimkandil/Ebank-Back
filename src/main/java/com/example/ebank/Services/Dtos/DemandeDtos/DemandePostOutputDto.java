package com.example.ebank.Services.Dtos.DemandeDtos;

import com.example.ebank.Entity.type_credit;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;

import java.io.Serializable;
import java.util.Objects;

public class DemandePostOutputDto implements Serializable {
    private Long id;

    private double montant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandePostOutputDto that = (DemandePostOutputDto) o;
        return Double.compare(montant, that.montant) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montant);
    }

    @Override
    public String
    toString() {
        return "DemandePostOutputDto{" +
                "id=" + id +
                ", montant=" + montant +
                '}';
    }
}
