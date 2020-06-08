package com.projet.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ci
 *
 */

@Entity
public class Client implements Serializable{


@Id
@GeneratedValue
private Long code;
private String nom;
private String prenom;
private Date dateNaiss;
private String email;
private String comment;
@OneToOne()
@JsonIgnore
private Adresse address;
private String sexe;
@OneToMany(mappedBy ="client",fetch = FetchType.LAZY)
@JsonIgnore
private List<Compte> comptes;


public Client() {
	super();
}








public Client(String nom, String prenom, Date dateNaiss, String email,String sexe,Adresse adress ,String comment ) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaiss = dateNaiss;
	this.email = email;
	this.sexe=sexe;
	this.address=adress;
	this.comment=comment;
}








public Long getCode() {
	return code;
}
public void setCode(Long code) {
	this.code = code;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public List<Compte> getComptes() {
	return comptes;
}
public void setComptes(List<Compte> comptes) {
	this.comptes = comptes;
}








public String getPrenom() {
	return prenom;
}








public void setPrenom(String prenom) {
	this.prenom = prenom;
}








public Date getDateNaiss() {
	return dateNaiss;
}








public void setDateNaiss(Date dateNaiss) {
	this.dateNaiss = dateNaiss;
}











	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}




	public Adresse getAddress() {
		return address;
	}

	public void setAddress(Adresse address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
