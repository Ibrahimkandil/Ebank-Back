package com.example.ebank.Config.service.Serviceimpl;


import com.example.ebank.Config.service.AuthenticationService;
import com.example.ebank.Config.service.JWTService;
import com.example.ebank.Dto.JwtAuthenticationResponse;
import com.example.ebank.Dto.SignUpRequest;
import com.example.ebank.Dto.SigninRequest;
import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Repository.IAdminRepo;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IEmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final IClientRepo iClientRepo;
    private final IAdminRepo iAdminRepo;
    private final IEmployeeRepo iEmployeeRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;



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


    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        String t= signinRequest.getIdentificationnumber();

        Admin admin = new Admin();
        Employee employee = new Employee();
        Client client = new Client();

        if(t.charAt(0)=='0'){
           admin  = iAdminRepo.findByIdentificationNumber(signinRequest.getIdentificationnumber()).orElseThrow(()->new IllegalArgumentException("Invalid email or password"));
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Admin.getEmail(), signinRequest.getPassword()));

        }else if (t.charAt(0)=='1') {
             employee = iEmployeeRepo.findByIdentificationNumber(signinRequest.getIdentificationnumber()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Employee.getEmail(), signinRequest.getPassword()));
        }else{
            client = iClientRepo.findByIdentificationnumber(signinRequest.getIdentificationnumber()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(client.getEmail(), signinRequest.getPassword()));
        }

         signinRequest.getPassword();
         if(t.charAt(0)=='0'){
            var jwt = jwtService.generateTokenadmin(admin);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setBody(admin);
            jwtAuthenticationResponse.setType("Admin");
            jwtAuthenticationResponse.setTime( new Date().toString());
             return jwtAuthenticationResponse;
        } else if (t.charAt(0)=='1') {
            var jwt = jwtService.generateTokenemployee(employee);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setBody(employee);
            jwtAuthenticationResponse.setType("Employee");
            jwtAuthenticationResponse.setTime( new Date().toString());
            return jwtAuthenticationResponse;
        }else{
            var jwt = jwtService.generateTokenclient(client);
            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setBody(client);
            jwtAuthenticationResponse.setType("Client");
            jwtAuthenticationResponse.setTime( new Date().toString());
            return jwtAuthenticationResponse;
        }

    }




}
