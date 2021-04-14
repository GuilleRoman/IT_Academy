/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici5;

/**
 *
 * @author juanj
 */
public class Punt {
    // ---------- Propietats ---------------------------------------------------
    private double posicioX;
    private double posicioY;
    
    //---------- Constructors --------------------------------------------------
    public Punt(int posicioX, int posicioY){
        this.posicioX=posicioX;
        this.posicioY=posicioY;
        
    }

    //---------- Getters, Setters and toString----------------------------------
    
    public double getPosicioX(){
        return posicioX;
    }
    
    public double getPosicioY(){
        return posicioY;
    }
    
    public void setPosicioX(int posX){
        this.posicioX=posX;
    }
    
    public void setPosicioY(int posY){
        this.posicioY=posY;
    }
    
    @Override
    public String toString(){
        return "posició x = "+posicioX+" posició y = "+posicioY;
    }    
    
}
