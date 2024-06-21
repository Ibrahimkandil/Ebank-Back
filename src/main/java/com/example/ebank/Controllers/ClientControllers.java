package com.example.ebank.Controllers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/client")

public class ClientControllers {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientOutputMapper clientOutputMapper;




    @GetMapping
    public  String SayHello(){
        return "Hello it's Client";
    }
    @GetMapping("/all")
    public List<ClientOutputDto> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public ClientOutputDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }




    @PostMapping("/reset/{id}")
        public String resetPassword(@PathVariable Long id, @RequestBody PasswordRequest password) {
            return clientService.resetPassword(id, password.getPassword());
        }

}

class  PasswordRequest {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
