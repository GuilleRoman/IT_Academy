/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici3;

import java.util.Date;

/**
 *
 * @author juanj
 */
public class Transaccio {
    //Propietats ---------------------------------------------------------------
    Date data;
    String concepte;
    double  importe;
    double saldo;    
    
    // Constructors ------------------------------------------------------------
    /**
     * Constructor per defecte, sense cap assignació.
     */
    public Transaccio(){
        
    }
    
    /**
     * Constructor amb tots els paràmetres:
     * 
     * @param data          Date
     * @param concepte      String
     * @param importe       double
     * @param saldo         double
     * 
     */
    public Transaccio(Date data, String concepte, double importe, double saldo) {
        this.data = data;
        this.concepte = concepte;
        this.importe = importe;
        this.saldo = saldo;
    }
    
    // GETTERS AND SETTERS -----------------------------------------------------

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getConcepte() {
        return concepte;
    }

    public void setConcepte(String concepte) {
        this.concepte = concepte;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Mètodes de la classe ----------------------------------------------------
    
    /**
     * toString
     * Mètode heretat de la classe Object, i per tant cal sobreescriure'l a cada classes per adaptar-lo.
     * @return      String      data,concepte,import,saldo
     */
    @Override
    public String toString() {
        return "data=" + data + ", concepte=" + concepte + ", importe=" + importe + ", saldo=" + saldo + '\n';
    }
    
    
}
