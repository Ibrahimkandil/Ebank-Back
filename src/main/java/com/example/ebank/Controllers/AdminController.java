package com.example.ebank.Controllers;

import com.example.ebank.Entity.*;
import com.example.ebank.Repository.*;
import com.example.ebank.Services.AdminService;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminInputDto;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import com.example.ebank.Services.Dtos.AgenceDto.AgenceOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeInputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteOutputDto;
import com.example.ebank.Services.Mappers.AdminMappers.AdminInputMapper;
import com.example.ebank.Services.Mappers.AdminMappers.AdminOutputMapper;
import com.example.ebank.Services.Mappers.AgenceMappers.AgenceOutputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeInputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeOutputMapper;
import com.example.ebank.Services.Mappers.contrat_preteMappers.contrat_preteOutputMapper;
import com.example.ebank.mail.EmailResponse;
import com.example.ebank.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Autowired
    private EmployeeOutputMapper employeeOutputMapper;
    @Autowired
    private EmployeeInputMapper employeeInputMapper;
    @Autowired
    private AgenceOutputMapper agenceOutputMapper;
    @Autowired
    private IAgenceRepo iAgenceRepo;
    @Autowired
    private IClientRepo iClientRepo;
    @Autowired
    private IAdminRepo iAdminRepo;
    @Autowired
    private IControlleRepo iControlleRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private contrat_preteOutputMapper contratPreteOutputMapper;
    @Autowired
    private AdminInputMapper adminInputMapper;
    @Autowired
    private AdminOutputMapper adminOutputMapper;

    @GetMapping
    public  String SayHello(){
        return "Hello it's Admin";
    }

    @PatchMapping("Update/{id}")
    public ResponseEntity<Object> updatAdmin(@PathVariable Long id, @RequestBody AdminInputDto adminInputDto) throws  Exception {
        try {
            Admin admin = iAdminRepo.findById(id).get();

            adminInputMapper.partialUpdate(admin, adminInputDto);
            Admin a=iAdminRepo.saveAndFlush(admin);
            return ResponseEntity.ok().body(adminOutputMapper.toDto(a));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("{\"message\": Erreur lors de la mise à jour des données du client}");

        }
    }
    @GetMapping("/all")
    public List<AdminOutputDto> getAllAdmins() {
        return this.adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminOutputDto getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }
    @GetMapping("employee/all")
    public ResponseEntity<Object> getAllEmployee() throws Exception{
        try {
            List<Employee> employees = iEmployeeRepo.findAll();
            List<EmployeeOutputDto> employeeOutputDtos = employees.stream()
                    .map(employeeOutputMapper::toDto)// Map each Client entity to ClientOutputDto using the mapper
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(employeeOutputDtos);
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Clients");

        }

        }
        @GetMapping("agencce/all")
    public ResponseEntity<Object> getAllAgence() throws Exception{
        try {
            List<Agence> agences = iAgenceRepo.findAll();
            List<AgenceOutputDto> agenceOutputDtos = agences.stream()
                    .map(agenceOutputMapper::toDto)// Map each Client entity to ClientOutputDto using the mapper
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(agenceOutputDtos);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Agence");


        }
    }
    @GetMapping("/clients-by-employee")
    public ResponseEntity<Object> getClientsByEmployee()  throws Exception{
        try {
            List<Object[]> results = iClientRepo.countClientsByEmployee().get();

            // Convert Object[] to Map<Long, Long> for easier JSON serialization
            List<Map<Long, Long>> clientCounts = results.stream()
                    .collect(Collectors.toMap(
                            array -> (Long) array[1], // Key: Employee ID
                            array -> (Long) array[0] // Value: Count of clients
                    ))
                    .entrySet().stream()
                    .map(entry -> {
                        Map<Long, Long> map = new HashMap<>();
                        map.put(entry.getKey(), entry.getValue());
                        return map;
                    })
                    .collect(Collectors.toList());


            return ResponseEntity.status(HttpStatus.OK).body(clientCounts);

        }catch (Exception e ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Datas");
        }
        }

    @PostMapping("addEmployee/{id}")
    public ResponseEntity<Object> addClient(@PathVariable Long id, @RequestBody EmployeeInputDto employeeInputDto) {
        Admin admin = iAdminRepo.findById(id).get();
        Employee employee=employeeInputMapper.toEntity(employeeInputDto);
        employee.setAdded_by(admin);
        employee.setIdentificationNumber(employee.Genrateur_Identification());
        employee.setPassword(employee.Genrateur_Motsdupasse());

        ZonedDateTime date = ZonedDateTime.now();
        employee.setDate_ajout(date);


        employee=iEmployeeRepo.save(employee);
        Controlle controlle=new Controlle();
        controlle.setId_User(employee.getId());
        controlle.setType("EMPLOYEE");
        controlle.setEtatCompte(EtatCompte.VERIFICATION);
        iControlleRepo.save(controlle);
        EmailResponse emailResponse = new EmailResponse();

        try {

            this.emailService.sendEmailtoClient(employee.getMail(),"Welcome to our Team",employee.getLast_name()+" "+ employee.getName(),employee.getIdentificationNumber(),employee.getPassword());
        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
        //       iclientRepo.save(client1);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/getContrats")
    public ResponseEntity<Object> getContrats() {
        try {
            List<contrat_prete> contrats = contratRepository.findAll();
            List<contrat_preteOutputDto> contratPreteOutputDtos = contrats.stream()
                    .map(contratPreteOutputMapper::toDto)// Map each Client entity to ClientOutputDto using the mapper
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(contratPreteOutputDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Contrats");
        }
    }


    @PostMapping("changerPass/{id}")
    public ResponseEntity<Object> changerPassword(@PathVariable Long id, @RequestBody ChangerPassword changerPassword) {
        Admin admin=iAdminRepo.findById(id).get();
        if(admin.getPassword()!=changerPassword.getPassword()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erroor Password Typed and password In DB are not the Same");

        }else{
            admin.setPassword(changerPassword.getNewPassword());
            iAdminRepo.saveAndFlush(admin);
            return ResponseEntity.status(HttpStatus.OK).body("Password Changed Successfully");
        }

    }
}


