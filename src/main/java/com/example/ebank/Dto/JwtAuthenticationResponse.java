package com.example.ebank.Dto;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class JwtAuthenticationResponse {
    private String token;
    private Object Body;
    private String type;
    private String time;
}
