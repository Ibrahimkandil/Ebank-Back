package com.example.ebank.Config.service.Serviceimpl;


import com.example.ebank.Config.service.JWTService;
import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {
    public String generateTokenclient(Client client){
        return Jwts.builder().setSubject(client.getFirst_name()+" "+client.getLast_name()+":"+client.getIdentificationNumber())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60*3))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateTokenemployee(Employee employee){
        return Jwts.builder().setSubject(employee.getName()+" "+employee.getLast_name()+":"+employee.getIdentificationNumber())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 6))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateTokenadmin(Admin admin){
        return Jwts.builder().setSubject(admin.getName()+" "+admin.getLast_name()+":"+admin.getIdentificationNumber())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers){
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    private Key getSignKey() {
        byte[] key = Decoders.BASE64.decode("413f4428472b4b6250655368566d5970337336763979244226452948404d6351" );
//       byte[] key = Decoders.BASE64.decode("QmFua0Z4" );
        return Keys.hmacShaKeyFor(key);
    }
    public String extractIdentificationNumber(String token) {

        String text= extractClaim(token, Claims::getSubject);
        return text.substring(text.indexOf(":")+1);
    }
    public  String extractName(String token) {
        String text= extractClaim(token, Claims::getSubject);
        return text.substring(0,text.indexOf(":"));
    }
    public  Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
    public boolean isTokenValidclient(String token, Client client) {
        final String username = extractName(token);
        final String identificationNumber = extractIdentificationNumber(token);
        return (username.equals(client.getFirst_name()+" "+client.getLast_name()) && identificationNumber.equals(client.getIdentificationNumber()) && !isTokenExpired(token));
    }
    public boolean isTokenValidemployee(String token, Employee employee) {
        final String username = extractName(token);
        final String identificationNumber = extractIdentificationNumber(token);
        return (username.equals(employee.getName()+" "+employee.getLast_name()) && identificationNumber.equals(employee.getIdentificationNumber()) && !isTokenExpired(token));
    }
    public boolean isTokenValidadmin(String token, Admin admin) {
        final String username = extractName(token);
        final String identificationNumber = extractIdentificationNumber(token);
        return (username.equals(admin.getName()+" "+admin.getLast_name()) && identificationNumber.equals(admin.getIdentificationNumber()) && !isTokenExpired(token));
    }
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }


}
