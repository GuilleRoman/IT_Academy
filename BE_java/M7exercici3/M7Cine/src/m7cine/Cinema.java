/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra Cinema.
 */
package m7cine;

import static java.lang.Double.isNaN;
import java.util.ArrayList;

/**
 *
 * @author Juan José Campos Caballero.
 */
public class Cinema {
    // PROPIETATS --------------------------------------------------------------
    private String nom;
    private ArrayList<Sala> sales = new ArrayList();
    
    // CONSTRUCTORS  -----------------------------------------------------------
    public Cinema(String nom) {
        this.nom = nom;
    }
    
    // GETTERS, SETTERS I toString  --------------------------------------------
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Sala> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sala> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Cinema{" + "nom=" + nom + ", sales=" + sales.toString() + '}';
    }
    
    // MÈTODES -----------------------------------------------------------------
    public void afegirSala(Sala sala){
        
        sales.add(sala);
    }
    
    public void eliminarSala(String nom){
        
    }
    
   
    
    
   
}
