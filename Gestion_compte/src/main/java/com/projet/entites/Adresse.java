package com.projet.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Adresse implements Serializable {
    @Id
    @GeneratedValue
    private String postalCode;
    private String country;
    private String city;
    private String principalAdress;
    private String code_adresse;
    public Adresse() {
    }

    public String getCode_adresse() {
        return code_adresse;
    }

    public void setCode_adresse(String code_adresse) {
        this.code_adresse = code_adresse;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrincipalAdress() {
        return principalAdress;
    }

    public void setPrincipalAdress(String principalAdress) {
        this.principalAdress = principalAdress;
    }
}
