/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it_academy;

/**
 *
 * @author juanj
 */
public class Persona {
    private String nom;
    private int edat;
    private String caracter;
    private Boolean bonaGent;

    public Persona(String nom, int edat, String caracter) {
        this.nom = nom;
        this.edat = edat;
        this.caracter = caracter;
        this.bonaGent=true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public Boolean getBonaGent() {
        return bonaGent;
    }

    public void setBonaGent(Boolean bonaGent) {
        this.bonaGent = bonaGent;
    }
    
    
    public int creixer(int anys){
        return this.edat+anys;
    }
    
    
    
    
    
}
