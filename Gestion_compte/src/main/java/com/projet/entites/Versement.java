package com.projet.entites;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

	public Versement(Date dateOpertion, double montant, Compte compte) {
		super(dateOpertion, montant, compte);
			}

	
}
