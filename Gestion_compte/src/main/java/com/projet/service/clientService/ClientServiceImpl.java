package com.projet.service.clientService;

import com.projet.dao.AdresseRepository;
import com.projet.dao.ClientRepository;
import com.projet.dao.CompteRepository;
import com.projet.entites.Adresse;
import com.projet.entites.Client;
import com.projet.entites.Compte;
import com.projet.service.clientService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Client createClient(Client cl) {

       if(cl!=null && cl.getAddress()!=null) {
           adresseRepository.save(cl.getAddress());
       }

       if(cl!=null && cl.getComptes()!=null) {
            for(Compte compte:cl.getComptes()){
                compteRepository.save(compte);
            }
       }

       Client client= clientRepository.save(cl);
       return client;
    }
}
