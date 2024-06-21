package com.example.ebank.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController("api/v1/mail")
public class EmailController {



    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
        EmailResponse emailResponse = new EmailResponse();
        try {
            emailService.sendEmail(emailRequest.getTo(), "Confirm your email address", emailRequest.getVerificationCode());
            emailResponse.setResponse("Email sent successfully!");
            return ResponseEntity.ok(emailResponse);
        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
    }
}


