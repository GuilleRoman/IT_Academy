/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra Cinema.
 */
package m7cine;

/**
 *
 * @author juan José Campos Caballero.
 */
public class Espectador {
    // PROPIETATS -------------------------------
    private String nom;
    private int edat;
    private double monedero;
    
    // CONSTRUCTORS -------------------------------
    public Espectador(String nom, int edat, double monedero){
        this.nom=nom;
        this.edat=edat;
        this.monedero=monedero;
    }
    
    // GETTERS, SETTERS, I toString() -------------
    public String getNom (){
        return nom;
    }
    
    public int getEdat (){
        return edat;
    }
    
    public double getMonedero (){
        return monedero;
    }
    
    public void setNom (String nom){
        this.nom = nom;
    }
    
    public void setEdat (int edat){
        this.edat=edat;
    }
    
    public void setMonedero (double monedero){
        this.monedero=monedero;
    }
    
    @Override
    public String toString (){
        return "Nom : "+nom+"\t\t Edat : "+edat+"\t\t Monedero : "+monedero;
    }
    
    //MÈTODES -------------------------------------
    
    
    
    
    
}
