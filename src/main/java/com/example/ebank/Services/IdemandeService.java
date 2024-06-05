package com.example.ebank.Services;

import com.example.ebank.Entity.Demande;
import com.example.ebank.Entity.Wallet;

import java.util.List;
import java.util.Optional;

public interface IdemandeService {
    List<Demande> getAlldemandes();
    Optional<Demande> getdemandeById(Long id);
    Demande createdemande(Demande demande);
    Demande updatedemande(Long id, Demande newdemandeData);
    void deletedemande(Long id);
}
