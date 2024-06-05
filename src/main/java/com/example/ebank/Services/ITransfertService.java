package com.example.ebank.Services;

import com.example.ebank.Entity.Transaction;
import com.example.ebank.Entity.Transfert;
import java.util.List;

public interface ITransfertService {
    Transfert addTransfert(Transfert transfert);
    Transfert getTransfert(Long id);
    List<Transfert> getAllTransferts();
    List<Transfert> getAllTranfertsByCompte(Long id);
}
