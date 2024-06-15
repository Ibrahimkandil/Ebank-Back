package com.example.ebank.Services.Criteria;


import com.example.ebank.Entity.Client;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;
import io.github.jhipster.service.filter.Filter;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class ClientCriteria  implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;
    private LongFilter id;
    private StringFilter last_name;
    private StringFilter Identification_Number;
    private StringFilter first_name;
    private StringFilter Paswword;
    private StringFilter Address;
    private StringFilter Phone;
    private StringFilter Email;
    private StringFilter Date_of_birth;

    private StringFilter Sexe;
    private ZonedDateTimeFilter Date_d_ajout;

    private StringFilter  etatCivil;

    private StringFilter  statutEmploi;

    private LongFilter addedBy;




    public static class ClientFilter extends Filter<Client> {

        public ClientFilter() {}

        public ClientFilter(ClientFilter filter) {
            super(filter);
        }

        @Override
        public ClientFilter copy() {
            return new ClientFilter(this);
        }
    }
    public ClientCriteria() {
    }
    public ClientCriteria(ClientCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.last_name = other.last_name == null ? null : other.last_name.copy();
        this.Identification_Number = other.Identification_Number == null ? null : other.Identification_Number.copy();
        this.first_name = other.first_name == null ? null : other.first_name.copy();
        this.Paswword = other.Paswword == null ? null : other.Paswword.copy();
        this.Address = other.Address == null ? null : other.Address.copy();
        this.Phone = other.Phone == null ? null : other.Phone.copy();
        this.Email = other.Email == null ? null : other.Email.copy();
        this.Date_of_birth = other.Date_of_birth == null ? null : other.Date_of_birth.copy();
        this.Sexe = other.Sexe == null ? null : other.Sexe.copy();
        this.Date_d_ajout = other.Date_d_ajout == null ? null : other.Date_d_ajout.copy();
        this.etatCivil = other.etatCivil == null ? null : other.etatCivil.copy();
        this.statutEmploi = other.statutEmploi == null ? null : other.statutEmploi.copy();
        this.addedBy = other.addedBy == null ? null : other.addedBy.copy();

    }

    @Override
    public ClientCriteria copy() {
        return new ClientCriteria(this);
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public void setLast_name(StringFilter last_name) {
        this.last_name = last_name;
    }

    public void setIdentification_Number(StringFilter identification_Number) {
        Identification_Number = identification_Number;
    }

    public void setFirst_name(StringFilter first_name) {
        this.first_name = first_name;
    }

    public void setPaswword(StringFilter paswword) {
        Paswword = paswword;
    }

    public void setAddress(StringFilter address) {
        Address = address;
    }

    public void setPhone(StringFilter phone) {
        Phone = phone;
    }

    public void setEmail(StringFilter email) {
        Email = email;
    }

    public void setDate_of_birth(StringFilter date_of_birth) {
        Date_of_birth = date_of_birth;
    }

    public void setSexe(StringFilter sexe) {
        Sexe = sexe;
    }

    public void setDate_d_ajout(ZonedDateTimeFilter date_d_ajout) {
        Date_d_ajout = date_d_ajout;
    }

    public void setEtatCivil(StringFilter etatCivil) {
        this.etatCivil = etatCivil;
    }

    public void setStatutEmploi(StringFilter statutEmploi) {
        this.statutEmploi = statutEmploi;
    }

    public void setAddedBy(LongFilter addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCriteria that = (ClientCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(last_name, that.last_name) && Objects.equals(Identification_Number, that.Identification_Number) && Objects.equals(first_name, that.first_name) && Objects.equals(Paswword, that.Paswword) && Objects.equals(Address, that.Address) && Objects.equals(Phone, that.Phone) && Objects.equals(Email, that.Email) && Objects.equals(Date_of_birth, that.Date_of_birth) && Objects.equals(Sexe, that.Sexe) && Objects.equals(Date_d_ajout, that.Date_d_ajout) && Objects.equals(etatCivil, that.etatCivil) && Objects.equals(statutEmploi, that.statutEmploi) && Objects.equals(addedBy, that.addedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, last_name, Identification_Number, first_name, Paswword, Address, Phone, Email, Date_of_birth, Sexe, Date_d_ajout, etatCivil, statutEmploi, addedBy);
    }

    @Override
    public String toString() {
        return "ClientCriteria{" +
                "id=" + id +
                ", last_name=" + last_name +
                ", Identification_Number=" + Identification_Number +
                ", first_name=" + first_name +
                ", Paswword=" + Paswword +
                ", Address=" + Address +
                ", Phone=" + Phone +
                ", Email=" + Email +
                ", Date_of_birth=" + Date_of_birth +
                ", Sexe=" + Sexe +
                ", Date_d_ajout=" + Date_d_ajout +
                ", etatCivil=" + etatCivil +
                ", statutEmploi=" + statutEmploi +
                ", addedBy=" + addedBy +
                '}';
    }
}
