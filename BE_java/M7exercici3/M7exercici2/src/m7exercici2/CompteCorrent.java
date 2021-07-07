/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici2;

import java.util.ArrayList;

/**
 *
 * @author juanj
 */
public class CompteCorrent {
    
    // Propietats. -------------------------------------------------------------
    String nom;
    String Cognoms;
    String numeroCompte;
    double saldo;
    ArrayList<Transaccio> transaccions= new ArrayList();
    
    //Constructor. -------------------------------------------------------------
    public CompteCorrent(String nom,String cognoms,String compteCorrent){
        this.nom=nom;
        this.Cognoms=cognoms;
        this.numeroCompte=compteCorrent;
        this.saldo=50;        
    }
    
    // Getters and Setters + toString ------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String Cognoms) {
        this.Cognoms = Cognoms;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transaccio> getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(ArrayList<Transaccio> transaccions) {
        this.transaccions = transaccions;
    }

    @Override
    public String toString() {
        return "CompteCorrent :" + numeroCompte + "\n" + "Titular :" + nom + ", "+ Cognoms + "\n" + "saldo= " + saldo +'\n';
    }
    
    // Mètodes -----------------------------------------------------------------
    
    public void afegirTransaccio(Transaccio transacc){
        transaccions.add(transacc);
    }
    
    
    /**
     * TransaccionsToString()
     * 
     * Retorna les transaccions realitzades sobre el compte corrent.
     * 
     * @return  String  Transaccions del compte  
     */
    public String TransaccionsToString(){
        String transaccionsRealitzades="";
                
        for(int i=0;i<transaccions.size();i++){
             transaccionsRealitzades+="- "+transaccions.get(i).toString();
        }
        
               
        return transaccionsRealitzades+= transaccions.size()+"  moviments al seu compte corrent. ";
            
    }
         
    
}
