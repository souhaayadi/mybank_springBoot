package com.projet.dao;

import com.projet.entites.Adresse;
import com.projet.entites.Client;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AdresseRepository  extends JpaRepository<Adresse,Long>{
}
