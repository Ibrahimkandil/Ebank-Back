package com.example.ebank.Dto;
import com.example.ebank.Entity.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class SignUpRequest {

    private String IdentificationNumber;
    private String last_name;
    private String first_name;
    private String Password;
    private String Email;



}

