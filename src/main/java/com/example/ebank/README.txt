Hello

1)j'ai implémenter les dtos et les mappers qui nous permet d'augmenter la sécurité :
il exsiste 3 type du DTOS et 3 type du mappers :
(on utilise les mapper pour mapper les objets et le transformer vers un dto spécifique ou vers un objet)
1)InputDto /InputMapper :se sont les dto/mapper responsable ppour l'entrée d'objet
on utilise comme entrée InputDto

PAR EXEMEPLE : (client)
@GetMapping("/Hello")
public String SayHello(@RequestBody ClientInputBody client);
//
c'est considérer comme un type just l'importer
et in utilise InputMapper pour transformer l'InputDto vers Entity
PAR EXEMPLE : (client)
//UPDATE Client
@PostMapping("/update")
public String UpdateClient(@RequestBody ClientInputDto client) {
Client c = clientIutputMapper.toEntity(c) //cette fonction permet le transformation vers un objet client
//on utilise toDto du le transformer vers un InputDto
}


2)OuputDto /OutputMapper :se sont les dto/mapper responsable pour le sortie  d'objet
on utilise comme entrée OutDto

PAR EXEMEPLE : (client)
@GetMapping("/Hello")
public ClientOutputDto SayHello(@RequestBody ClientInputBody client);
//
c'est considérer comme un type just l'importer
et in utilise InputMapper pour transformer l'InputDto vers Entity
PAR EXEMPLE : (client)
//UPDATE Client
@PostMapping("/update")
public ClientOutputDto UpdateClient(@RequestBody ClientInputDto client) {
Client c = clientIutputMapper.toEntity(c);
 return this.clientOutPutMapper.toDto(c);
 //cette fonction permet le transformation vers un Dto client
//on utilise toEntity du le transformer vers un InputDto
}


3) Dto/Mapper :se sont les dto/mapper responsable pour les traitments des objets et les dto
on utilise comme entrée OutDto


PAR EXEMPLE : (client)
//UPDATE Client
@PostMapping("/update")
public ClientOutputDto UpdateClient(@RequestBody ClientInputDto client) {
Client c = clientIutputMapper.toEntity(c);
Client cl = clientMapper.partialUpdate(c,client);
this.iadminRepo.save(cl);
//cette fonction permet du faire upadate c en utilisant client
}


=>LES dto sont rarement utilisée et le besoin du Dto/Mapper du faire les partial Update



Les Mapper/OutputMapper/InputMapper
sont déclarés
PAR EXEMPLE : (client)
@Autowired
private ClientOutputMapper clientOutputMapper;
private ClientIntputMapper clientIntputMapper;
private ClientMapper clientMapper;




4)J'ai implémenter l'utilisation des jwt token et la vérification du sécurité
Il faut utiliser un url pour géner un token qui sont collé dans
(cas Postman):Autorisation /selectionner Bearer Token /coller le token génerer
Pas du token inséreé =>403 (Forbidden)
les étapes :
utiliser cetter endpoint pour génerer un token
Méthode: "POST"
url: "http://localhost:8080/ebank/api/v1/auth/signin"
//*
les utilisateur sont divisée par leurs code d'identification :
Si le code d'Identification commence par "0" : c'est un admin
Si le code d'Identification commence por "1" : c'est un Employée
*//
Body/JSON :  {
           "identificationnumber":"0001"(écrire le numéro d'identification du utilisateur),

           "password":"0000"
        }Sinon : c'est un Client


JWT token => est une token génrer qui contient le nom du utilisateur/son numéro d'identification + date du création + date d'expiration
par exemple : (un token génrer)
token : "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW5kaWwgaWJyYWhpbTowMDAxIiwiaWF0IjoxNzE4MzY3MDkzLCJleHAiOjE3MTgzNzA2OTN9.ozgkmUFx9pM6dmxv-1MmikI96-vlTQsJSMTK3Huew9E"

PAYLOAD:DATA
{
  "sub": "kandil ibrahim:0001",(c'est un admin
  "iat": 1718367093,(crée: le Fri Jun 14 2024 14:11:33)
  "exp": 1718370693(fin: le Fri Jun 14 2024 15:11:33)
}
l'utilisation des token va être obligatoire et je vais insérer le token dans le cookie pour l'utlisation