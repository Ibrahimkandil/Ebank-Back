package com.example.ebank.Dto;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private Object Body;
    private String type;
    private String time;
    private String time_Expiration;
    private List<Map<String, String>> Menus;
    private String Etat;
}
