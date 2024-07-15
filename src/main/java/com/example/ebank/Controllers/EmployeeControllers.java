package com.example.ebank.Controllers;

import com.example.ebank.Entity.*;
import com.example.ebank.Repository.*;
import com.example.ebank.Services.ClientService;
import com.example.ebank.Services.Dtos.ClientDtos.ClientInputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.DemandeDtos.DemandeOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeInputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Dtos.ReclamationDtos.ReclamationOutputDto;

import com.example.ebank.Services.EmployeeService;
import com.example.ebank.Services.Mappers.ClientMappers.ClientInputMapper;
import com.example.ebank.Services.Mappers.ClientMappers.ClientOutputMapper;
import com.example.ebank.Services.Mappers.DemandeMappers.DemandeOutputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeInputMapper;
import com.example.ebank.Services.Mappers.EmployeeMappers.EmployeeOutputMapper;
import com.example.ebank.Services.Mappers.ReclamationMappers.ReclamationOutputMapper;
import com.example.ebank.Services.Mappers.TransactionMappers.TransactionOutputMapper;
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
    @Autowired
    private ClientOutputMapper clientOutputMapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionOutputMapper transactionOutputMapper;
    @Autowired
    private DemandeRepoisitory demandeRepoisitory;
    @Autowired
    private DemandeOutputMapper demandeOutputMapper;
    @Autowired
    private IreclamationRepo reclamationRepository;
    @Autowired
    private ReclamationOutputMapper reclamationOutputMapper;
    @Autowired
    private TransfertRepository transfertRepository;
    @Autowired
    private IControlleRepo iControlleRepo;
    @Autowired
    private EmployeeInputMapper employeeInputMapper;
    @Autowired
    private EmployeeOutputMapper employeeOutputMapper;
    @Autowired
    private Compte_BancaireRepository compteBancaireRepository;

    @PatchMapping("Confirmation_compte/{id}")
    public ResponseEntity<Object> Confirmation_compte(@PathVariable Long id, @RequestBody SignatureCompte signature) throws Exception {
        try {
            Controlle controlle = iControlleRepo.getControlleByUserIdANDType(id, "EMPLOYEE").get();
            controlle.setConfirmation(signature.getImage_data());
            controlle.setEtatCompte(EtatCompte.ACTIF);
            iControlleRepo.saveAndFlush(controlle);
            return ResponseEntity.ok().body("{\"message\": \"Votre compte est ACTIF\"}");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("{\"message\": \"Erreur lors d'Activation\"}");
        }
    }
    @PatchMapping("Demande_Suppression/{id}")
    public ResponseEntity<Object> Demande_Suppression(@PathVariable Long id, @RequestBody SignatureCompte signature) throws Exception  {
        try {


        Controlle controlle=iControlleRepo.getControlleByUserIdANDType(id,"EMPLOYEE").get();
        controlle.setDemande_suppression(signature.getImage_data());
        controlle.setEtatCompte(EtatCompte.DEMANDE);
        iControlleRepo.saveAndFlush(controlle);
        return ResponseEntity.ok().body("{\"message\": \"Demande de suppression a était accepté\"}");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body("{\"message\": \"Erreur lors de l'Enregistrement du Demande du Suppression\"}");

        }
    }
    @PatchMapping("Update/{id}")
    public ResponseEntity<Object> updatEmployee(@PathVariable Long id, @RequestBody EmployeeInputDto employeeInputDto) throws  Exception {
        try {
            Employee employee = iEmployeeRepo.findById(id).get();

            employeeInputMapper.partialUpdate(employee, employeeInputDto);
            Employee a=iEmployeeRepo.saveAndFlush(employee);
            return ResponseEntity.ok().body(employeeOutputMapper.toDto(a));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("{\"message\": Erreur lors de la mise à jour des données du client}");

        }
    }
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

        client1=iclientRepo.save(client1);
        Controlle controlle=new Controlle();
        controlle.setId_User(client1.getId());
        controlle.setType("CLIENT");
        controlle.setEtatCompte(EtatCompte.VERIFICATION);
        iControlleRepo.save(controlle);
        EmailResponse emailResponse = new EmailResponse();
        Compte_Bancaire compteBancaire=new Compte_Bancaire();
        compteBancaire.setClient(client1);
        Date dd=new Date();
        dd.setYear(dd.getYear()+2);
        compteBancaire.setClosing_date(dd.toString());
        compteBancaire.setOpening_date(ZonedDateTime.now());
        compteBancaire.setBalance(0);
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10); // Generate a single digit
            accountNumber.append(digit); // Append the digit to the account number
        }
        compteBancaire.setAccount_number(accountNumber.toString());
        compteBancaire.setInterest_rate(1);
        compteBancaire.setAccount_type(Type_Compte.Compte_Courant);
        compteBancaireRepository.save(compteBancaire);


        try {

        this.emailService.sendEmailtoClient(client1.getEmail(),"Welcome to our bank",client1.getLast_name()+" "+ client1.getFirst_name(),client1.getIdentificationNumber(),client1.getPassword());
        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
        }
        //       iclientRepo.save(client1);
        ClientOutputDto clientOutputDto=clientOutputMapper.toDto(client1);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientOutputDto);
    }



        @GetMapping("/allDatas")
        public ResponseEntity<Object> getAllTransactions() {
            try {
                List<Object[]> totalAmountsByDate = transactionRepository.findTotalAmountsByCreationDate();
                List<Object[]> totalTransferAmountsByDate = transfertRepository.findTotalAmountsAndTransfersByCreationDate();

                // Map to store the aggregated result
                Map<String, TransactionAmountsDto> formattedResult = new HashMap<>();

                // Process total amounts
                for (Object[] data : totalAmountsByDate) {
                    ZonedDateTime creationDate = (ZonedDateTime) data[0];
                    double totalAmount = (double) data[1];

                    TransactionAmountsDto dto = new TransactionAmountsDto();
                    dto.setTotalAmount(totalAmount);

                    formattedResult.put(creationDate.toString(), dto);
                }

                // Process transfer amounts and merge into formattedResult
                for (Object[] data : totalTransferAmountsByDate) {
                    ZonedDateTime creationDate = (ZonedDateTime) data[0];
                    double totalTransferAmount = (double) data[1];

                    if (formattedResult.containsKey(creationDate.toString())) {
                        TransactionAmountsDto dto = formattedResult.get(creationDate.toString());
                        dto.setTotalTransferAmount(totalTransferAmount);
                    } else {
                        TransactionAmountsDto dto = new TransactionAmountsDto();
                        dto.setTotalAmount(0); // or dto.setTotalAmount((double) data[1]); if needed
                        dto.setTotalTransferAmount(totalTransferAmount);
                        formattedResult.put(creationDate.toString(), dto);
                    }
                }

                return ResponseEntity.status(HttpStatus.OK).body(formattedResult);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        }
        @GetMapping("/notifiactions")
    public ResponseEntity<Object> getNotificaitons(){
            List<Demande> demandes= this.demandeRepoisitory.findAll();
            List<DemandeOutputDto> demandeOutputDtos=demandes.stream().map(demandeOutputMapper::toDto).collect(Collectors.toList());


            List<Reclamation> reclamations= this.reclamationRepository.findAll();
            List<ReclamationOutputDto> reclamationOutputDtos=reclamations.stream().map(reclamationOutputMapper::toDto).collect(Collectors.toList());
            Map<String, Object> formattedResult = new HashMap<>();
            formattedResult.put("demandes", demandeOutputDtos);
            formattedResult.put("reclamations", reclamationOutputDtos);
            if(formattedResult.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }else {
                return ResponseEntity.status(HttpStatus.OK).body(formattedResult);
            }
        }


    @PostMapping("/contact")
    public ResponseEntity<String> SendContact( @RequestBody Email_du_contact emailDuContact) {
        String username = iclientRepo.getUserNameByEmail(emailDuContact.getTo()).get();


        EmailResponse emailResponse = new EmailResponse();

        try {

            this.emailService.sendEmailContact(emailDuContact.getTo(),emailDuContact.getSujet(),emailDuContact.getText(),username);
            return ResponseEntity.status(HttpStatus.OK).body("Email a était Envoyé vers Le Client");

        } catch (Exception e) {
            emailResponse.setResponse("Error sending email: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse.toString());
        }
        //       iclientRepo.save(client1);
    }
    @PostMapping("changerPass/{id}")
    public ResponseEntity<Object> changerPassword(@PathVariable Long id, @RequestBody ChangerPassword changerPassword) {
        Employee employee=iEmployeeRepo.findById(id).get();
        if(employee.getPassword()!=changerPassword.getPassword()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erroor Password Typed and password In DB are not the Same");

        }else{
            employee.setPassword(changerPassword.getNewPassword());
            iEmployeeRepo.saveAndFlush(employee);
            return ResponseEntity.status(HttpStatus.OK).body("Password Changed Successfully");
        }

    }




}
 class TransactionAmountsDto {

    private double totalAmount;
    private double totalTransferAmount;

     public double getTotalAmount() {
         return totalAmount;
     }

     public void setTotalAmount(double totalAmount) {
         this.totalAmount = totalAmount;
     }

     public double getTotalTransferAmount() {
         return totalTransferAmount;
     }

     public void setTotalTransferAmount(double totalTransferAmount) {
         this.totalTransferAmount = totalTransferAmount;
     }



}

class Email_du_contact {
    String to;
    String sujet;
    String text;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
class SignatureCompte {

private byte[] image_data;


    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }
}