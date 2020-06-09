package com.projet.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name ="TypeCompte",discriminatorType = DiscriminatorType.STRING,length =2)
public  class Compte implements Serializable{
	@Id
	private int codeCompte;
	private Date dateCreation;
	private double solde;
	private String typeCpt;

	/*@ManyToOne()
	@JsonIgnore
	private Client client;*/
	@OneToMany(mappedBy ="compte",fetch = FetchType.LAZY)
	@JsonIgnore
	private Collection<Operation> operations;


	public Compte() {
	}


	public Compte(int codeCompte, Date dateCreation, double solde,String typeCpt) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;

		this.typeCpt=typeCpt;
	}


	public int getCodeCompte() {
		return codeCompte;
	}

	public void setCodeCompte(int codeCompte) {
		this.codeCompte = codeCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


/*	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}*/


	public Collection<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	public String getTypeCpt() {
		return typeCpt;
	}

	public void setTypeCpt(String typeCpt) {
		this.typeCpt = typeCpt;
	}
}
