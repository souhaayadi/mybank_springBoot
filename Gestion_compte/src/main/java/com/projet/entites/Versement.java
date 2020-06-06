package com.projet.entites;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity(name = "Versement")
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement() {
	}

	public Versement(Date dateOpertion, double montant, Compte compte) {
		super(dateOpertion, montant, compte);
		// TODO Auto-generated constructor stub
	}


}
