package tn.esprit.magasin.controllers;

import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Profession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.magasin.services.IClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin("http://localhost:4200")
public class ClientRestController {

@Autowired
IClientService clientService;

// http://localhost:8082/SpringMVC/client/retrieve-all-clients
@GetMapping("/retrieve-all-clients")
@ResponseBody
public List<Client> getClients() {
List<Client> listClients = clientService.retrieveAllClients();
return listClients;
}
//http://localhost:8082/SpringMVC/client/retrieve-client/8
@GetMapping("/retrieve-client/{client-id}")
@ResponseBody
public Client retrieveClient(@PathVariable("client-id") Long clientId) {
return clientService.retrieveClient(clientId);
}
//http://localhost:8082/SpringMVC/client/add-client
@PostMapping("/add-client")
@ResponseBody
public Client addClient(@RequestBody Client c)
{
Client client = clientService.addClient(c);
return client;
}
//http://localhost:8082/SpringMVC/client/remove-client/{client-id}
@DeleteMapping("/remove-client/{client-id}")
@ResponseBody
public void removeClient(@PathVariable("client-id") Long clientId) {
clientService.deleteClient(clientId);
}
//http://localhost:8082/SpringMVC/client/modify-client
@PutMapping("/modify-client")
@ResponseBody
public Client modifyClient(@RequestBody Client client) {
return clientService.updateClient(client);
}
//http://localhost:8082/SpringMVC/client/retrieve-all-clients-By-Profession
@GetMapping("/retrieve-all-clients-By-Profession/{profession}")
@ResponseBody
public  List<Client>  listClient(@PathVariable("profession") Profession profession) {
return clientService.retrieveClientsByProfession(profession);
}
@GetMapping("/retrieve/{username}")
@ResponseBody
public  Client  getClient(@PathVariable("username") String username) {
return clientService.getByUserName(username);
}


}
