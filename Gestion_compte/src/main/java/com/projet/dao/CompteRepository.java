package com.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entites.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
