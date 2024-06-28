package com.example.ebank.Controllers;

import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Entity.genre;
import com.example.ebank.Repository.IClientRepo;
import com.example.ebank.Repository.IEmployeeRepo;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.EmployeeService;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.mail.EmailResponse;
import com.example.ebank.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllers {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientInputMapper clientInputMapper;
    @Autowired
    private IClientRepo iclientRepo;
    @Autowired
    private EmailService emailService;

    @GetMapping
    public  String SayHello(){
        return "Hello it's Employee";
    }
    @GetMapping("/allClients")
    public List<ClientOutputDto> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/all")
    public List<EmployeeOutputDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeOutputDto getEmployeeById(@PathVariable Long id ){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("addClient/{id}")
    public ResponseEntity<Object> addClient(@PathVariable Long id, @RequestBody ClientInputDto client) {
        Employee employee = iEmployeeRepo.findById(id).get();
        System.out.println(client);
        Client client1=clientInputMapper.toEntity(client);
        client1.setAddedBy(employee);
        client1.setIdentificationNumber(client1.Genrateur_Identification());
        client1.setPassword(client1.Genrateur_Motsdupasse());
        ZonedDateTime date = ZonedDateTime.now();
        client1.setDate_d_ajout( date);
        client1.setAddress(client.getAddress());
        client1.setPhone(client.getPhone());
        client1.setEmail(client.getEmail());
        client1.setDate_of_birth(client.getDate_of_birth());
        client1.setSexe(genre.Homme);
        System.out.println(client1);
        EmailResponse emailResponse = new EmailResponse();

        try {

        this.emailService.sendEmailtoClient(client1.getEmail(),"Welcome to our bank",client1.getLast_name()+" "+ client1.getFirst_name(),client1.getIdentificationNumber(),client1.getPassword());
        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
        //       iclientRepo.save(client1);
        return ResponseEntity.status(HttpStatus.CREATED).body(client1);
    }
}
