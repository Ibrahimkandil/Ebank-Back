package com.example.ebank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public enum etatCivil {
    @Enumerated(EnumType.STRING)
    CELIBATAIRE,
    MARIE,
    DIVORCE,
    VEUF
}
