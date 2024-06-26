package com.example.ebank.Services.Mappers.contrat_preteMappers;

import com.example.ebank.Entity.contrat_prete;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteInputDto;
import com.example.ebank.Services.Mappers.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public abstract class contrat_preteIputMapper implements EntityMapper<contrat_preteInputDto, contrat_prete> {
    public abstract contrat_prete toEntity(contrat_preteInputDto dto) ;

    public abstract contrat_preteInputDto toDto(contrat_prete entity);

    public contrat_prete partialUpdate(contrat_prete entity, contrat_prete dto) {
        if (dto.getDuree() != 0) {
            entity.setDuree(dto.getDuree());
        }
        if (dto.getDate_debut() != null) {
            entity.setDate_debut(dto.getDate_debut());
        }
        if (dto.getDate_fin() != null) {
            entity.setDate_fin(dto.getDate_fin());
        }
        if (dto.getMontant() != 0) {
            entity.setMontant(dto.getMontant());
        }
        if (dto.getMensualites() != 0) {
            entity.setMensualites(dto.getMensualites());
        }
        if (dto.getFrequencePaiement() != null) {
            entity.setFrequencePaiement(dto.getFrequencePaiement());
        }
        if (dto.getTypeInteret() != null) {
            entity.setTypeInteret(dto.getTypeInteret());
        }
        if (dto.getTypeCredit() != null) {
            entity.setTypeCredit(dto.getTypeCredit());
        }
        if (dto.getFraisDossier() != 0) {
            entity.setFraisDossier(dto.getFraisDossier());
        }
        if (dto.getTypeInteret() != null) {
            entity.setTypeInteret(dto.getTypeInteret());
        }
        if (dto.getEtatContrat() != null) {
            entity.setEtatContrat(dto.getEtatContrat());
        }
        if (dto.getInformationsAssurance() != null) {
            entity.setInformationsAssurance(dto.getInformationsAssurance());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getClient() != null) {
            entity.setClient(dto.getClient());
        }
        if (dto.getDemande() != null) {
            entity.setDemande(dto.getDemande());
        }

        return entity;

    }
}
