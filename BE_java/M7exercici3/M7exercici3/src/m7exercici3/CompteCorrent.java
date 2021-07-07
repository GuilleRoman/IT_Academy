/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici3;

import java.util.ArrayList;

/**
 *
 * @author juanj
 */
public class CompteCorrent {
    // Propietats. -------------------------------------------------------------
    String numeroCompte;
    double saldo;
    ArrayList<Transaccio> transaccions= new ArrayList();
    
    //Constructor. -------------------------------------------------------------
    public CompteCorrent(String compteCorrent){
        this.numeroCompte=compteCorrent;
        this.saldo=50;        
    }
    
    // Getters and Setters + toString ------------------------------------------


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
        return "CompteCorrent :" + numeroCompte + "\n"+ "saldo= " + saldo +'\n';
    }
    
    // Mètodes -----------------------------------------------------------------
    /**
     * afegirTransaccio
     * 
     * Afegeix una transacció al l'array de comptes.
     * 
     * @param transacc 
     */
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
