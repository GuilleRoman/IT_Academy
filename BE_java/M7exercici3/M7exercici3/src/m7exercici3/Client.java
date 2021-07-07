/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici3;

import java.util.ArrayList;

/**
 *M7 exercici 3
 * 
 * @author juanjo Campos
 */
public class Client {
   
    //propietats ---------------------------------------------------------------
    String nom;
    String cognoms;
    ArrayList<CompteCorrent> comptes= new ArrayList();
    
    //Constructors--------------------------------------------------------------

    public Client(String nom, String cognoms) {
        this.nom = nom;
        this.cognoms = cognoms;
    }
    
    // Getters and Setters -----------------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public ArrayList<CompteCorrent> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<CompteCorrent> comptes) {
        this.comptes = comptes;
    }
    
    // Mètodes toString  -------------------------------------------------------

    @Override
    public String toString() {
        return "Titular: "+ nom + ", "+cognoms+'\n';
    }
    
    // Mètodes -----------------------------------------------------------------
    public void afegirCompteCorrent(CompteCorrent compte){
        comptes.add(compte);
    }
    
    public void mostrarComptesCorrents(){
        
        for(int i=0;i<comptes.size();i++){
            System.out.println("Compte : "+comptes.get(i).getNumeroCompte()+"  "+comptes.get(i).getSaldo()+" euros");
        }
    }
    
    public int existeixElCompte(String numCompte){
        for(int i=0;i<comptes.size();i++){
            if(numCompte.equals(comptes.get(i).getNumeroCompte())){
                return i;
            }
        }
        return -1;
    }    
    
}
