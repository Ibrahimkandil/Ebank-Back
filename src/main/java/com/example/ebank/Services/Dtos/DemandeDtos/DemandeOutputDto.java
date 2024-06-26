package com.example.ebank.Services.Dtos.DemandeDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.type_credit;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;

import java.io.Serializable;
import java.util.Objects;

public class DemandeOutputDto implements Serializable {
    private Long id;

    private ClientPostOutputDto client;
    private double montant;


    private type_credit type;

    private String raisonDemandeCredit;
    private String TypeObj;

    public String getTypeObj() {
        return TypeObj;
    }

    public void setTypeObj(String type) {
        this.TypeObj = type;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientPostOutputDto getClient() {
        return client;
    }

    public void setClient(ClientPostOutputDto client) {
        this.client = client;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public type_credit getType() {
        return type;
    }

    public void setType(type_credit type) {
        this.type = type;
    }

    public String getRaisonDemandeCredit() {
        return raisonDemandeCredit;
    }

    public void setRaisonDemandeCredit(String raisonDemandeCredit) {
        this.raisonDemandeCredit = raisonDemandeCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeOutputDto that = (DemandeOutputDto) o;
        return Double.compare(montant, that.montant) == 0 && Objects.equals(id, that.id) && Objects.equals(client, that.client) && type == that.type && Objects.equals(raisonDemandeCredit, that.raisonDemandeCredit) && Objects.equals(TypeObj, that.TypeObj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, montant, type, raisonDemandeCredit, TypeObj);
    }

    @Override
    public String toString() {
        return "DemandeOutputDto{" +
                "id=" + id +
                ", client=" + client +
                ", montant=" + montant +
                ", type=" + type +
                ", raisonDemandeCredit='" + raisonDemandeCredit + '\'' +
                ", TypeObj='" + TypeObj + '\'' +
                '}';
    }
}

