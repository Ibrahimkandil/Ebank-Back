package com.example.ebank.Config.service.Serviceimpl;


import com.example.ebank.Config.service.AuthenticationService;
import com.example.ebank.Dto.JwtAuthenticationResponse;
import com.example.ebank.Dto.SignUpRequest;
import com.example.ebank.Dto.SigninRequest;
import com.example.ebank.Entity.*;
import com.example.ebank.Repository.IAdminRepo;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IControlleRepo;
import com.example.ebank.Repository.IEmployeeRepo;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientPostOutMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeePOSTOutputMapper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final IClientRepo iClientRepo;
    private final IAdminRepo iAdminRepo;
    private final IEmployeeRepo iEmployeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTServiceImpl jwtService;
    private final ClientPostOutMapper clientPostOutMapper;
    private final EmployeePOSTOutputMapper employeePOSTOutputMapper;
    private final IControlleRepo iControlleRepo;



    public Client signupClient(SignUpRequest signUpRequest){
        Client client = new Client();
        client.setFirst_name(signUpRequest.getFirst_name());
        client.setIdentificationNumber(signUpRequest.getIdentificationNumber());
        client.setLast_name(signUpRequest.getLast_name());
        client.setEmail(signUpRequest.getEmail());
        client.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return iClientRepo.save(client);
    }
    public Employee signupEmployee(SignUpRequest signUpRequest){
        Employee employee = new Employee();

        employee.setName(signUpRequest.getFirst_name());
        employee.setIdentificationNumber(signUpRequest.getIdentificationNumber());
        employee.setLast_name(signUpRequest.getLast_name());
        employee.setMail(signUpRequest.getEmail());
        employee.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return iEmployeeRepo.save(employee);
    }
    public Admin signupAdmin(SignUpRequest signUpRequest){
        Admin admin = new Admin();
        admin.setName(signUpRequest.getFirst_name());
        admin.setIdentificationNumber(signUpRequest.getIdentificationNumber());
        admin.setLast_name(signUpRequest.getLast_name());
        admin.setMail(signUpRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        return iAdminRepo.save(admin);
    }


    public JwtAuthenticationResponse signin(SigninRequest signinRequest)   {
        String t= signinRequest.getIdentificationnumber();

        Admin admin = new Admin();
        Employee employee = new Employee();
        Client client = new Client();
        Controlle controlle = new Controlle();
        List<Map<String, String>> menus = new ArrayList<>();
        Map<String, String> menu0 = new HashMap<>();
        menu0.put("index", "Paramétre");
        menu0.put("link", "Settings");


        if(t.charAt(0)=='0'){
           admin  = iAdminRepo.findByIdentificationNumber(signinRequest.getIdentificationnumber()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Admin.getEmail(), signinRequest.getPassword()));

        }else if (t.charAt(0)=='1') {
             employee = iEmployeeRepo.findByIdentificationAndPassword(signinRequest.getIdentificationnumber(),signinRequest.getPassword()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
//
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Employee.getEmail(), signinRequest.getPassword()));
            controlle=iControlleRepo.getControlleByUserIdANDType(employee.getId(),"EMPLOYEE").get();
            if(controlle.getEtatCompte()== EtatCompte.DEMANDE){
                throw new IllegalArgumentException("Votre compte est en attente de validation du SUPPRESSION vous ne pouvez pas Connecter");
            }
        }else{
            client = iClientRepo.findByIdentificationAndPassword(signinRequest.getIdentificationnumber(),signinRequest.getPassword()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(), signinRequest.getPassword()));
            controlle=iControlleRepo.getControlleByUserIdANDType(client.getId(),"CLIENT").get();
            if(controlle.getEtatCompte()== EtatCompte.DEMANDE){
                throw new IllegalArgumentException("Votre compte est en attente de validation du SUPPRESSION vous ne pouvez pas Connecter");
            }
        }

         signinRequest.getPassword();
         if(t.charAt(0)=='0'){
            var jwt = jwtService.generateTokenadmin(admin);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setBody(admin);
            jwtAuthenticationResponse.setType("Admin");
            jwtAuthenticationResponse.setTime( new Date().toString());
             jwtAuthenticationResponse.setEtat("ACITF");
             jwtAuthenticationResponse.setTime_Expiration(this.jwtService.extractClaim(jwt, Claims::getExpiration).toString());


             // Create the first menu item
             Map<String, String> menu1 = new HashMap<>();
             menu1.put("index", "Home");
             menu1.put("link", "interface3");
             menus.add(menu1);

             // Create the second menu item
             Map<String, String> menu2 = new HashMap<>();
             menu2.put("index", "Ajouter Employee");
             menu2.put("link", "interface3/form");
             menus.add(menu2);
             menus.add(menu0);
             jwtAuthenticationResponse.setMenus(menus);
             return jwtAuthenticationResponse;
        } else if (t.charAt(0)=='1') {
            var jwt = jwtService.generateTokenemployee(employee);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
             EmployeePOSTOutputDto employeePOSTOutputDto=this.employeePOSTOutputMapper.toDto(employee);
             jwtAuthenticationResponse.setBody(employeePOSTOutputDto);
            jwtAuthenticationResponse.setType("Employee");
             jwtAuthenticationResponse.setEtat(controlle.getEtatCompte().toString());

             jwtAuthenticationResponse.setTime_Expiration(this.jwtService.extractClaim(jwt, Claims::getExpiration).toString());

             jwtAuthenticationResponse.setTime( new Date().toString());

             // Create the first menu item
             Map<String, String> menu1 = new HashMap<>();
             menu1.put("index", "Home");
             menu1.put("link", "interface2");
             menus.add(menu1);

             // Create the second menu item
             Map<String, String> menu2 = new HashMap<>();
             menu2.put("index", "Ajouter Client");
             menu2.put("link", "interface2/form");
             menus.add(menu2);
             menus.add(menu0);
             jwtAuthenticationResponse.setMenus(menus);
            return jwtAuthenticationResponse;
        }else{
            var jwt = jwtService.generateTokenclient(client);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
             ClientPostOutputDto clientPostOutputDto=this.clientPostOutMapper.toDto(client);
            jwtAuthenticationResponse.setBody(clientPostOutputDto);
            jwtAuthenticationResponse.setType("Client");

             jwtAuthenticationResponse.setEtat(controlle.getEtatCompte().toString());


             // Create the first menu item
             Map<String, String> menu1 = new HashMap<>();
             menu1.put("index", "Home");
             menu1.put("link", "interface1");
             menus.add(menu1);

             // Create the second menu item
             Map<String, String> menu2 = new HashMap<>();
             menu2.put("index", "Wallet");
             menu2.put("link", "wallet");
             menus.add(menu2);
             menus.add(menu0);
             jwtAuthenticationResponse.setMenus(menus);
            jwtAuthenticationResponse.setTime_Expiration(this.jwtService.extractClaim(jwt, Claims::getExpiration).toString());
            jwtAuthenticationResponse.setTime( new Date().toString());
            return jwtAuthenticationResponse;
        }

    }




}
