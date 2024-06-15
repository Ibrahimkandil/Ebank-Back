package com.example.ebank.Config;


import com.example.ebank.Config.service.JWTService;
import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Services.AdminService;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.EmployeeService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final ClientService clientService;
    private final AdminService adminService;

    private final IClientRepo iClientRepo;
    private final EmployeeService employeeService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String name;
        final String identificationNumber;
        if(StringUtils.isEmpty(authHeader) || !org.apache.commons.lang3.StringUtils.startsWith(authHeader,("Bearer ")) ){

            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(7);
        name = jwtService.extractName(jwt);
        identificationNumber = jwtService.extractIdentificationNumber(jwt);
    if(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(identificationNumber) && SecurityContextHolder.getContext().getAuthentication()== null) {

        if(identificationNumber.charAt(0)=='0'){
            Admin admin = adminService.getAdminByIdentificationNumber(identificationNumber);

            if(jwtService.isTokenValidadmin(jwt,admin)){
                SecurityContext securityContext= SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);


            }
        } else if (identificationNumber.charAt(0)=='1') {
            Employee employee = employeeService.getEmployeeByIdentificationNumber(identificationNumber);

            if(jwtService.isTokenValidemployee(jwt,employee)){
                SecurityContext securityContext= SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(employee, null, employee.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);


            }
        }else{
            Client client = clientService.getClientByIdentificationNumber(identificationNumber);
            if(jwtService.isTokenValidclient(jwt,client)){
                SecurityContext securityContext= SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(client, null, client.getAuthorities());
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);


            }
        }

    }
        filterChain.doFilter(request, response);


    }
}
