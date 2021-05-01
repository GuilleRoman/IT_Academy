/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra   Ruleta Russa.
 */
package m7ruletarussa;

import java.util.Arrays;


/**
 *
 * @author Juan José Campos Caballero.
 */
public class Revolver {
    // propietats ----------------------------------------
    private int posicioActual;
    private int posicioBala;    
    
     // Constructors ----------------------------------------
    public Revolver() {        
        // genero la posició actual i la posició de la bala
        posicioActual=generarIntAleatori(0,5);        
        posicioBala=generarIntAleatori(0,5);
    }

     // Getters, Setters i toString ----------------------------------------
    public int getPosicioActual() {
        return posicioActual;
    }

    public void setPosicioActual(int posicioActual) {
        this.posicioActual = posicioActual;
    }

    public int getPosicioBala() {
        return posicioBala;
    }

    public void setPosicioBala(int posicioBala) {
        this.posicioBala = posicioBala;
    }

   

    @Override
    public String toString() {
        return "Revolver{ " + "posicioActual=" + posicioActual + ", posicioBala=" + posicioBala +" }";
    }
    
     // Mètodes ----------------------------------------
    
    public Boolean disparar(){
        Boolean tret=false;
        
        if(posicioActual==posicioBala){
            tret=true;
        } 
        
        return tret;
    }
    
    public void siguienteBala(){
        if(posicioActual==5){
            posicioActual=0;
        }else{
            posicioActual++;
        }
            
    }
    
    
    public void informar(){
        System.out.println("- "+this.toString());
        
    }
    
    
    
    /**
     * omplirTambor
     * 
     * Carrega aleatoriament la bala i la posició actual al tambor.
     */
    public void omplirTambor(){
        // genero la posició actual i la posició de la bala
        posicioActual=generarIntAleatori(1,6);        
        posicioBala=generarIntAleatori(1,6);
        
    }



     /**
     * generarIntAleatori
     * 
     * Genera un nombre aleatori entre min i max.
     * 
     * @param       min      int aleatori mínim
     * @param       max      int aleatori màxim
     * @return      nombre   int random [min..max] 
     */
    public static int generarIntAleatori(int min, int max){
        int nombre=(int) Math.floor(Math.random()*max+min);
        return nombre;
    }    


    
}


