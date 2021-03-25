/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici2;

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
    int transaccions;
    
    //Constructor. -------------------------------------------------------------
    public CompteCorrent(String nom,String cognoms,String compteCorrent){
        this.nom=nom;
        this.Cognoms=cognoms;
        this.numeroCompte=compteCorrent;
        this.saldo=50;
        this.transaccions=0;
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

    public int getTransaccions() {
        return transaccions;
    }

    public void setTransaccions(int transaccions) {
        this.transaccions = transaccions;
    }

    @Override
    public String toString() {
        return "CompteCorrent :" + numeroCompte + "\n" + "Titular :" + nom + ", "+ Cognoms + "\n" + "saldo= " + saldo + "\ntransaccions=" + transaccions + '\n';
    }
    
    // Mètodes -----------------------------------------------------------------
    
            
    
}
