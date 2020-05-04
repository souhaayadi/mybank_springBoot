package com.projet.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeOperation",discriminatorType = DiscriminatorType.STRING,length =1)
public abstract class Operation implements Serializable {
	@Id
	@GeneratedValue
private Long numero;
private Date dateOpertion;
private double montant;
@ManyToOne
@JoinColumn(name="CODE_COMPTE")
private Compte compte;

public Operation() {
	super();
}
public Operation(Date dateOpertion, double montant, Compte compte) {
	super();
	this.dateOpertion = dateOpertion;
	this.montant = montant;
	this.compte = compte;
}
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}
public Date getDateOpertion() {
	return dateOpertion;
}
public void setDateOpertion(Date dateOpertion) {
	this.dateOpertion = dateOpertion;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}


}
