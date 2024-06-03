package com.example.ebank.Services;

import com.example.ebank.Repository.ITransfertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransfertService implements ITransfertService{

    private final ITransfertRepo TransfertRepo ;

    @Autowired
    public TransfertService(ITransfertRepo TransfertRepo) {
        this.TransfertRepo = TransfertRepo;
    }
}
