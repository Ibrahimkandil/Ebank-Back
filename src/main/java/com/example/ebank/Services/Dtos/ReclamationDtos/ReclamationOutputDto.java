package com.example.ebank.Services.Dtos.ReclamationDtos;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;

import java.time.ZonedDateTime;
import java.util.Objects;

public class ReclamationOutputDto {
    private Long id;

    private ClientPostOutputDto client;

    private String subject;
    private String description;
    private ZonedDateTime date;
    private String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        ReclamationOutputDto that = (ReclamationOutputDto) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(subject, that.subject) && Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, subject, description, date);
    }

    @Override
    public String toString() {
        return "ReclamationOutputDto{" +
                "id=" + id +
                ", client=" + client +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
