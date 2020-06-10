package com.projet.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.dao.ClientRepository;
import com.projet.dao.CompteRepository;
import com.projet.dao.OperationRepository;
import com.projet.entites.Client;
import com.projet.entites.Compte;
import com.projet.entites.CompteCourant;
import com.projet.entites.CompteEpargne;
import com.projet.entites.Operation;
import com.projet.entites.Retrait;
import com.projet.entites.Versement;

@RestController
@CrossOrigin("*")
public class CompteRestService {
	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OperationRepository operationRepository;

	@GetMapping("/comptes")
	public List<Compte> getAllCompte(){
		return compteRepository.findAll();
	}

	public Compte consulterCompte(String codeCompte) {
		Compte cp = compteRepository.findByCodeCompte(Integer.parseInt(codeCompte));
		if (cp == null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@PutMapping("/comptes/verser/{codeCompte}&{montant}")
	public HttpEntity<Compte> verser(@PathVariable  String codeCompte, @PathVariable double montant) {
		Compte result;
		Compte cp=consulterCompte(codeCompte);
		cp.setSolde(cp.getSolde()+montant);
		Versement v =new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		result= consulterCompte(codeCompte);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PutMapping("/comptes/retirer/{codeCompte}&{montant}")
	public HttpEntity<Compte> retirer(@PathVariable  String codeCompte, @PathVariable double montant) {
		Compte result;
		Compte cp=consulterCompte(codeCompte);
		double faciliteCaisse=0;
		if(cp instanceof CompteCourant)
			faciliteCaisse=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+faciliteCaisse < montant){
			throw new RuntimeException("Solde insuffisant");

		}
		else {
			cp.setSolde(cp.getSolde()-montant);
			Retrait v =new Retrait(new Date(), montant, cp);
			operationRepository.save(v);
			result= consulterCompte(codeCompte);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}

	@PutMapping("/comptes/virement/{codeCompte1}&{codeCompte2}&{montant}")
	public HttpEntity<List<Compte>> virement(@PathVariable String codeCompte1, @PathVariable String codeCompte2, @PathVariable double montant)
	{
		List<Compte> result = new ArrayList<>();
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);
		Compte compte1= consulterCompte(codeCompte1);
		Compte compte2= consulterCompte(codeCompte2);
		result.add(compte1);
		result.add(compte2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/comptes/listOperation")
	public List<Operation> listOperation(@RequestParam(name = "codeCompte") String codeCompte,
										 @RequestParam (name = "page", defaultValue ="0") int page,
										 @RequestParam (name = "size", defaultValue = "5") int size) {
        List<Operation> operation= new ArrayList<>();
		operation= operationRepository.listOperation(Integer.parseInt(codeCompte), PageRequest.of(page, size)).getContent();
		return operation;

	}

	@PutMapping("/comptes/addCpCourant/{codeClient}&{codeCompte}&{solde}&{decouvert}")
	public void addComptecourant(@PathVariable Long codeClient,@PathVariable int codeCompte ,@PathVariable double solde,@PathVariable double decouvert,@PathVariable String typeCpt) {
		Client c=clientRepository.findById(codeClient).orElse(null);
		//if(typeCompte == "CC")	
		CompteCourant cc =  new CompteCourant(codeCompte,new Date(),solde,decouvert,typeCpt);
		compteRepository.save(cc);

	}

	@PutMapping("/comptes/addCpEpargne/{codeClient}&{codeCompte}&{solde}&{taux}")
	public void addCompteEpargne(@PathVariable Long codeClient,@PathVariable int codeCompte ,@PathVariable double solde,@PathVariable double taux,@PathVariable String typeCpt) {
		Client c=clientRepository.findById(codeClient).orElse(null);
		//if(typeCompte == "CC")	
		CompteEpargne ce=new CompteEpargne(codeCompte,new Date(),solde,taux,typeCpt);
		compteRepository.save(ce);
	}
	@DeleteMapping("/comptes/{codeCompte}")
	public HttpEntity<Boolean> deleteAccount(@PathVariable int codeCompte) {
		Boolean result;
		try{
			compteRepository.deleteById(Integer.toString(codeCompte));
			result=true;
		}
		catch (Exception e){
			result=false;
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}


}
