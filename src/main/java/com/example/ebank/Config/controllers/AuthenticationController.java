package com.example.ebank.Config.controllers;


import com.example.ebank.Config.service.AuthenticationService;
import com.example.ebank.Dto.JwtAuthenticationResponse;
import com.example.ebank.Dto.SignUpRequest;
import com.example.ebank.Dto.SigninRequest;
import com.example.ebank.Entity.*;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import com.example.ebank.mail.EmailRequest;
import com.example.ebank.mail.EmailResponse;
import com.example.ebank.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final EmailService emailService;
    private final AuthenticationService authenticationService;
    private final ClientService clientService;
    private final ClientOutputMapper clientOutputMapper;


    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@RequestBody SigninRequest signinRequest) throws Exception {
        try {
            return ResponseEntity.ok(authenticationService.signin(signinRequest));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
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
    @PostMapping("/sendEmail")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
        EmailResponse emailResponse = new EmailResponse();
        String receivedEncryptedVerificationCode = emailRequest.getVerificationCode();
        String verficiationCode =this.emailService.decrypt(receivedEncryptedVerificationCode);
        try {
            emailService.sendEmail(emailRequest.getTo(), "Confirm your email address", verficiationCode);
            emailResponse.setResponse("Email sent successfully!");
            return ResponseEntity.ok(emailResponse);
        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
    }

    @PostMapping("/getEmail")
    public EmailResponseReset getClientByEmail(@RequestBody EmailRequestReset email) {

        Client client =    clientService.getClientByEmail(email.getEmail());
        SigninRequest signinRequest = new SigninRequest();
        signinRequest.setIdentificationnumber(client.getIdentificationNumber());
        signinRequest.setPassword(client.getPassword());
        JwtAuthenticationResponse jwtAuthResp = authenticationService.signin(signinRequest);
        EmailResponseReset emailResponseReset = new EmailResponseReset();
        emailResponseReset.setClient(clientOutputMapper.toDto(client));
        emailResponseReset.setToken(jwtAuthResp.getToken());
        return emailResponseReset;
    }

}

class EmailRequestReset{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class  EmailResponseReset {
    private ClientOutputDto client;
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public ClientOutputDto getClient() {
        return this.client;
    }

    public void setClient(ClientOutputDto client) {
        this.client = client;
    }
}


