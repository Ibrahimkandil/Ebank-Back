package com.example.ebank.Services.Dtos.ReclamationDtos;

import com.example.ebank.Entity.Client;
import org.mapstruct.Mapper;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

public class ReclamationInputDto implements Serializable {
    private Long id;

    private Client client;

    private String subject;
    private String description;
    private ZonedDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReclamationInputDto that = (ReclamationInputDto) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(subject, that.subject) && Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, subject, description, date);
    }

    @Override
    public String toString() {
        return "ReclamationDto{" +
                "id=" + id +
                ", client=" + client +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
