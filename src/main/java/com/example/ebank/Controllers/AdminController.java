package com.example.ebank.Controllers;

import com.example.ebank.Entity.*;
import com.example.ebank.Repository.*;
import com.example.ebank.Services.AdminService;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminInputDto;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import com.example.ebank.Services.Dtos.AgenceDto.AgenceOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientPostOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeInputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeePOSTOutputDto;
import com.example.ebank.Services.Dtos.contrat_preteDtos.contrat_preteOutputDto;
import com.example.ebank.Services.Mappers.AdminMappers.AdminInputMapper;
import com.example.ebank.Services.Mappers.AdminMappers.AdminOutputMapper;
import com.example.ebank.Services.Mappers.AgenceMappers.AgenceOutputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientPostOutMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeInputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeOutputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeePOSTOutputMapper;
import com.example.ebank.Services.Mappers.contrat_preteMappers.contrat_preteOutputMapper;
import com.example.ebank.mail.EmailResponse;
import com.example.ebank.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private IEmployeeRepo iEmployeeRepo;
    @Autowired
    private  IClientRepo iClientRepo;
    @Autowired
    private EmployeeOutputMapper employeeOutputMapper;
    @Autowired
    private EmployeeInputMapper employeeInputMapper;
    @Autowired
    private AgenceOutputMapper agenceOutputMapper;
    @Autowired
    private IAgenceRepo iAgenceRepo;
    @Autowired
    private DemandeRepoisitory demandeRepoisitory;

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
    @Autowired
    private ClientPostOutMapper clientPostOutMapper;
    @Autowired
    private EmployeePOSTOutputMapper employeePOSTOutputMapper;
    @Autowired
    private IwalletRepo iwalletRepo;
    @Autowired
    private Compte_BancaireRepository Compte_BancaireRepository;

    @GetMapping
    public  String SayHello(){
        return "Hello it's Admin";
    }
    @GetMapping("controlle/{id}")
    public ResponseEntity<Object> controlle(@PathVariable Long id){
        try {
            Controlle controlle = iControlleRepo.findById(id).get();

            return ResponseEntity.status(HttpStatus.OK).body(controlle);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Datas");
        }
    }
    @GetMapping("demande_suppression")
    public  ResponseEntity<Object> suppression(){
        try {
            List<Controlle> controlles = iControlleRepo.getControlleByType(EtatCompte.DEMANDE).get();
            List<Object> controlleObject = new ArrayList<>();
            for (Controlle controlle : controlles) {
                if ("CLIENT".equals(controlle.getType())) {
                    List<Object> list=new ArrayList<>();
                    list.add(controlle.getId());
                    list.add(controlle.getType());
                    list.add(controlle.getEtatCompte());

                    // Assuming getClientById is a method to fetch Client entity by id_compte
                    Client client = iClientRepo.findById(controlle.getId_User()).get();
                    // Assuming clientToDto is a method to transform Client entity to ClientPostOutputDto
                    ClientPostOutputDto dto =clientPostOutMapper.toDto(client);
                    list.add(dto);
                    controlleObject.add(list);

                } else if ("Employee".equals(controlle.getType())) {
                    // Assuming getEmployeeById is a method to fetch Employee entity by id_compte
                    Employee employee = iEmployeeRepo.findById(controlle.getId_User()).get();
                    // Assuming employeeToDto is a method to transform Employee entity to EmployeePostOutputDto
                    EmployeePOSTOutputDto dto = employeePOSTOutputMapper.toDto(employee);
                    List<Object> list=new ArrayList<>();
                    list.add(controlle.getId());
                    list.add(controlle.getType());
                    list.add(controlle.getEtatCompte());
                    list.add(dto);
                    controlleObject.add(list);
                }
            }

            return ResponseEntity.status(HttpStatus.OK).body(controlleObject);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Lors du Fetching Datas");
        }
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
//            Iterator<Object[]> iterator = results.iterator();
//
//            while (iterator.hasNext()) {
//                Object[] array = iterator.next();
//                Client client = iClientRepo.findById((Long) array[1]).get();
//                if (client.getAddedBy() == null) {
//                    iterator.remove();
//                }
//            }

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


        @PostMapping("/supprimer")
    public ResponseEntity<String> SuppressionUser( @RequestBody Email_du_Suppression emailDuSuppression) {


        EmailResponse emailResponse = new EmailResponse();
        try {


            String username="";

                if(emailDuSuppression.getReponse().equals("DELETE") ){

                if (  emailDuSuppression.type.equals("Client")) {
                    Client user = iClientRepo.findById(emailDuSuppression.getId()).get();
                    username = user.getLast_name() + " " + user.getFirst_name();
                    List<Wallet> wallets=iwalletRepo.findByClientId(user.getId()).get();
                    for(Wallet wallet : wallets){
                        iwalletRepo.deleteById(wallet.getId());
                    }
                    List<Compte_Bancaire> compteBancaires=Compte_BancaireRepository.findByIdClient(user.getId()).get();
                    for(Compte_Bancaire compteBancaire:compteBancaires){
                        compteBancaire.setClient(null);
                        Compte_BancaireRepository.saveAndFlush(compteBancaire);
                    }




                    iClientRepo.deleteById(user.getId());
                } else {
                    Employee user = iEmployeeRepo.findById(emailDuSuppression.getId()).get();
                    username = user.getLast_name() + " " + user.getName();
                    List<Client> clients=iClientRepo.getClientsByEmployee(user.getId()).get();
                    for(Client client:clients){
                        client.setAddedBy(null);
                    }
                    iClientRepo.saveAllAndFlush(clients);
                    iEmployeeRepo.delete(user);


                }
                }


                this.emailService.sendEmailSuppression(emailDuSuppression.getTo(), emailDuSuppression.getSujet(), emailDuSuppression.getReponse(), username);
                Controlle controlle = iControlleRepo.getControlleByClientIdANDType(emailDuSuppression.getId(), emailDuSuppression.getType()).get();
                if(emailDuSuppression.getReponse().equals("DELETE")){
                controlle.setSuppresion(emailDuSuppression.getImage_data());
                controlle.setEtatCompte(EtatCompte.SUPPRIME);
                iControlleRepo.saveAndFlush(controlle);
                }else{
                    controlle.setDemande_suppression(null);
                    controlle.setEtatCompte(EtatCompte.ACTIF);
                    iControlleRepo.saveAndFlush(controlle);
                }
                return ResponseEntity.status(HttpStatus.OK).body("Email a était Envoyé vers Le Client");


        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse.toString());
        }
        //       iclientRepo.save(client1);

    }
}


class  Email_du_Suppression {
    private byte[] image_data;
    String to;
    String sujet;
    String reponse;
    Long id;
    String type;

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String text) {
        this.reponse = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}