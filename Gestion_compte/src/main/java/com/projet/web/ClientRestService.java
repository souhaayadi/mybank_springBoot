package com.projet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.ClientRepository;
import com.projet.entites.Client;

@RestController
@CrossOrigin("*")
public class ClientRestService {
	@Autowired
private ClientRepository clientRepository;
	
	
@GetMapping("/clients")
public List<Client> getAllClient(){
	return clientRepository.findAll();
	}


	
@GetMapping("/clients/{codeClient}") 
 public Client consulterClient(@PathVariable Long codeClient) {
	
		  return clientRepository.findById(codeClient).orElse(null);
			
}

@PostMapping("/clients") 
public Client addClient(@RequestBody Client cl) {

		  return clientRepository.save(cl);
			
}

@DeleteMapping("/clients/{codeClient}") 
public Boolean supprimerClient(@PathVariable Long codeClient) {
	  clientRepository.deleteById(codeClient);
	  return true;	
}
	 

@PutMapping("/clients/{codeClient}") 
public Client updateClient(@PathVariable Long codeClient, @RequestBody Client cl) {
	cl.setCode(codeClient);
	 return  clientRepository.save(cl);
	 	
}
	

}
	
