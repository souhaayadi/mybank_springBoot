package com.projet.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	public Retrait() {

	}

	public Retrait(Date dateOpertion, double montant, Compte compte) {
		super(dateOpertion, montant, compte);

	}




}
