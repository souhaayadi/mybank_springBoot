package com.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.entites.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

	
}
