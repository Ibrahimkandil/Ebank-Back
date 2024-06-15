package com.example.ebank.Config.controllers;


import com.example.ebank.Config.service.AuthenticationService;
import com.example.ebank.Dto.JwtAuthenticationResponse;
import com.example.ebank.Dto.SignUpRequest;
import com.example.ebank.Dto.SigninRequest;
import com.example.ebank.Entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
    @PostMapping("/signup/client")

    public ResponseEntity<Client> signupClient(@RequestBody SignUpRequest signUpRequest) {
        return  ResponseEntity.ok(authenticationService.signupClient(signUpRequest));
    }


    @PostMapping("/signup/admin")

    public ResponseEntity<Admin> singupAdmin(@RequestBody SignUpRequest signUpRequest) {
        return  ResponseEntity.ok(authenticationService.signupAdmin(signUpRequest));
    }
    @PostMapping("/signup/employee")

    public ResponseEntity<Employee> singupEmployee(@RequestBody SignUpRequest signUpRequest) {
        return  ResponseEntity.ok(authenticationService.signupEmployee(signUpRequest));
    }
}
