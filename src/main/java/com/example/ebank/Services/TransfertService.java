package com.example.ebank.Services;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Entity.Transfert;
import com.example.ebank.Repository.ITransfertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransfertService implements ITransfertService{

    private final ITransfertRepo TransfertRepo ;

    @Autowired
    public TransfertService(ITransfertRepo TransfertRepo) {
        this.TransfertRepo = TransfertRepo;
    }

    @Override
    public Transfert addTransfert(Transfert transfert) {
        return TransfertRepo.save(transfert);
    }

    @Override
    public Transfert getTransfert(Long id) {
        Optional<Transfert> transfert = TransfertRepo.findById(id);
        if (transfert.isPresent()) {
            return transfert.get();
        }
        return null;
    }

    @Override
    public List<Transfert> getAllTransferts() {
        return TransfertRepo.findAll();
    }

    @Override
    public List<Transfert> getAllTranfertsByCompte(Long id) {
        List<Transfert> AllTranferts = getAllTransferts();
        List<Transfert> TransfertsByUser = new ArrayList<>();

        for (Transfert transfert : AllTranferts) {
            if (transfert.getIdCompteSource().getId().equals(id)) {
                TransfertsByUser.add(transfert);
            }
        }
        return TransfertsByUser;
    }

}
