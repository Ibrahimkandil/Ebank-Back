package com.example.ebank.Dto;
import lombok.Data;

@Data
public class SigninRequest {
    private String identificationnumber;
    private String password;
}
