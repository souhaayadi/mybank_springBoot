package com.projet.web;

import java.util.List;

import com.projet.service.clientService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.dao.ClientRepository;
import com.projet.entites.Client;
import com.projet.entites.Operation;

@RestController
@CrossOrigin("*")
public class ClientRestService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getAllClient(){
		return clientRepository.findAll();
	}



	@GetMapping("/clients/{codeClient}")
	public Client consulterClient(@PathVariable Long codeClient) {

		return clientRepository.findById(codeClient).orElse(null);

	}

	@PostMapping("/clients")
	public HttpEntity<Client> addClient(@RequestBody Client cl) {
         Client result;
         result= clientRepository.save(cl);
		return new ResponseEntity<>(result, HttpStatus.OK);

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

	@GetMapping("clients/listClient")
	public Page<Client> listClient(@RequestParam(name = "mc", defaultValue = "") String mc,
								   @RequestParam (name = "page", defaultValue ="0") int page,
								   @RequestParam (name = "size", defaultValue = "5") int size) {
		return clientRepository.listClient("%"+mc+"%",  PageRequest.of(page, size));

	}
}
	
