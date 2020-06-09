package com.projet.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux ;



	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int codeCompte, Date dateCreation, double solde,  double taux,String typeCpt) {
		super(codeCompte, dateCreation, solde,typeCpt);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
