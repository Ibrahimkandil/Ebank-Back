package com.example.ebank.Config.service;


import com.example.ebank.Dto.JwtAuthenticationResponse;
import com.example.ebank.Dto.SignUpRequest;
import com.example.ebank.Dto.SigninRequest;
import com.example.ebank.Entity.*;

public interface AuthenticationService {
    Client signupClient(SignUpRequest signUpRequest);
    Employee signupEmployee(SignUpRequest signUpRequest);
    Admin signupAdmin(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
}
