/*
 * IT ACADEMY 
 * Fonaments de la programació
 * POO
 */
package it_academy;

/**
 *
 * @author juanjo Campos Caballero
 */
public class Hotel {
    
// Propietats --------------------------------------------------------------
    private String nom;
    private int nombreHabitacions;
    private int nombrePlantes;
    private int superficie;
    
// Constructors ------------------------------------------------------------
    
    public Hotel(String nom){
        this.nom=nom;
        this.nombreHabitacions=0;
        this.nombrePlantes=0;       
        this.superficie=0;
    }
    
    public Hotel(String nom,int nombreHab,int nombrePlantes,int superficie){
        this.nom=nom;
        this.nombreHabitacions=nombreHab;
        this.nombrePlantes=nombrePlantes;
        this.superficie=superficie;
    }    
    
// Getters and Setters ------------------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreHabitacions() {
        return nombreHabitacions;
    }

    public void setNombreHabitacions(int nombreHabitacions) {
        this.nombreHabitacions = nombreHabitacions;
    }

    public int getNombrePlantes() {
        return nombrePlantes;
    }

    public void setNombrePlantes(int nombrePlantes) {
        this.nombrePlantes = nombrePlantes;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    
// MÈTODE DE LA CLASSE -----------------------------------------------------
    @Override
    public String toString() {
        return "Hotel: "+ nom + "\n - nombreHabitacions=" + nombreHabitacions + "\n - nombrePlantes=" + nombrePlantes + "\n - superficie=" + superficie+'\n';
    }
    
    /**
     * 
     * @return  persones  int  nombre de persones de manteniment 
     */
    public int calcularManteniment(){
        int persones=this.nombreHabitacions/20;
        return persones;
    }
    
    public double calcularCostManteniment(){
        double costTotal=calcularManteniment()*1500;
        return costTotal;
    }        
    
}
