package com.example.ebank.Services.Dtos.contrat_preteDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Demande;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class contrat_preteInputDto implements Serializable {
    private long id;
    private int duree;
    private ZonedDateTime date_debut;
    private ZonedDateTime date_fin;
    private double montant;
    private double mensualites;

    private String frequencePaiement;
    private String typeInteret;
    private String typeCredit;
    private double fraisDossier;

    private String etatContrat;

    private String informationsAssurance;
    private String description;

    private Client client;
    private Demande demande;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public ZonedDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(ZonedDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public ZonedDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(ZonedDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMensualites() {
        return mensualites;
    }

    public void setMensualites(double mensualites) {
        this.mensualites = mensualites;
    }

    public String getFrequencePaiement() {
        return frequencePaiement;
    }

    public void setFrequencePaiement(String frequencePaiement) {
        this.frequencePaiement = frequencePaiement;
    }

    public String getTypeInteret() {
        return typeInteret;
    }

    public void setTypeInteret(String typeInteret) {
        this.typeInteret = typeInteret;
    }

    public String getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(String typeCredit) {
        this.typeCredit = typeCredit;
    }

    public double getFraisDossier() {
        return fraisDossier;
    }

    public void setFraisDossier(double fraisDossier) {
        this.fraisDossier = fraisDossier;
    }

    public String getEtatContrat() {
        return etatContrat;
    }

    public void setEtatContrat(String etatContrat) {
        this.etatContrat = etatContrat;
    }

    public String getInformationsAssurance() {
        return informationsAssurance;
    }

    public void setInformationsAssurance(String informationsAssurance) {
        this.informationsAssurance = informationsAssurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        contrat_preteInputDto that = (contrat_preteInputDto) o;
        return id == that.id && duree == that.duree && Double.compare(montant, that.montant) == 0 && Double.compare(mensualites, that.mensualites) == 0 && Double.compare(fraisDossier, that.fraisDossier) == 0 && Objects.equals(date_debut, that.date_debut) && Objects.equals(date_fin, that.date_fin) && Objects.equals(frequencePaiement, that.frequencePaiement) && Objects.equals(typeInteret, that.typeInteret) && Objects.equals(typeCredit, that.typeCredit) && Objects.equals(etatContrat, that.etatContrat) && Objects.equals(informationsAssurance, that.informationsAssurance) && Objects.equals(description, that.description) && Objects.equals(client, that.client) && Objects.equals(demande, that.demande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duree, date_debut, date_fin, montant, mensualites, frequencePaiement, typeInteret, typeCredit, fraisDossier, etatContrat, informationsAssurance, description, client, demande);
    }

    @Override
    public String toString() {
        return "contrat_preteDto{" +
                "id=" + id +
                ", duree=" + duree +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", montant=" + montant +
                ", mensualites=" + mensualites +
                ", frequencePaiement='" + frequencePaiement + '\'' +
                ", typeInteret='" + typeInteret + '\'' +
                ", typeCredit='" + typeCredit + '\'' +
                ", fraisDossier=" + fraisDossier +
                ", etatContrat='" + etatContrat + '\'' +
                ", informationsAssurance='" + informationsAssurance + '\'' +
                ", description='" + description + '\'' +
                ", client=" + client +
                ", demande=" + demande +
                '}';
    }
}
