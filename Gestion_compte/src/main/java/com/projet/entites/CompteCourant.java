package com.projet.entites;


import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	private double decouvert;



	public CompteCourant() {
		super();
	}

	public CompteCourant(int codeCompte, Date dateCreation, double solde, double decouvert,String typeCpt) {
		super(codeCompte, dateCreation, solde,typeCpt);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}


}
