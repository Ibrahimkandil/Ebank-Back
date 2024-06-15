package com.example.ebank.Config.service;


import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String extractName(String token);
    String extractIdentificationNumber(String token);
    String generateTokenadmin(Admin userDetails);
    String generateTokenclient(Client userDetails);
    String generateTokenemployee(Employee userDetails);
    boolean isTokenValidadmin(String token, Admin user);
    boolean isTokenValidclient(String token, Client client);
    boolean isTokenValidemployee(String token, Employee employee);
}
