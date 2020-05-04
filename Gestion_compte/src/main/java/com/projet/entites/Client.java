package com.projet.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
private String adresss;

@OneToMany(mappedBy ="client",fetch = FetchType.LAZY)
@JsonIgnore
private Collection<Compte> comptes;


public Client() {
	super();
}








public Client(String nom, String prenom, Date dateNaiss, String email, String adresss) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaiss = dateNaiss;
	this.email = email;
	this.adresss = adresss;
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
public Collection<Compte> getComptes() {
	return comptes;
}
public void setComptes(Collection<Compte> comptes) {
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








public String getAdresss() {
	return adresss;
}








public void setAdresss(String adresss) {
	this.adresss = adresss;
}


}
