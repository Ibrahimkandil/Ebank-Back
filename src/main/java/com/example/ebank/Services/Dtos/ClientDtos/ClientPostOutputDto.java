package com.example.ebank.Services.Dtos.ClientDtos;

import java.util.Objects;

public class ClientPostOutputDto {
    private Long id;
    private String last_name;
    private String first_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPostOutputDto that = (ClientPostOutputDto) o;
        return Objects.equals(id, that.id) && Objects.equals(last_name, that.last_name) && Objects.equals(first_name, that.first_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, last_name, first_name);
    }

    @Override
    public String toString() {
        return "ClientPostOutputDto{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
