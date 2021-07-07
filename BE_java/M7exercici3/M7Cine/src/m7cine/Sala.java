/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7cine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juanj
 */
public class Sala {
    // PROPIETATS --------------------------------------------------------------
    private String nom;
    private int aforament;
    private int entradesVenudes;
    private int files;
    private int columnes;
    private int filaOcupada;
    private int columnaOcupada;
    private Pelicula pelicula;
    private double preuEntrada;
    private Espectador [][] planoSala;
    
    // CONSTRUCTORS ------------------------------------------------------------
    
    public Sala(String nom, int files, int columnes){
        this.nom=nom;
        this.aforament=files*columnes;
        this.files=files;
        this.columnes=columnes;
        this.filaOcupada=0;
        this.columnaOcupada=0;
        this.entradesVenudes=0;
                
        planoSala = new Espectador [files][columnes];
        
    }

   
    
    // GETTERS, SETTERS toString -----------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public int getFiles() {
        return files;
    }

    public void setFiles(int files) {
        this.files = files;
    }

    public int getColumnes() {
        return columnes;
    }

    public void setColumnes(int columnes) {
        this.columnes = columnes;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPreuEntrada() {
        return preuEntrada;
    }

    public void setPreuEntrada(double preuEntrada) {
        this.preuEntrada = preuEntrada;
    }

    public Espectador [][] getPlanoSala() {
        return planoSala;
    }

    public void setPlanoSala(Espectador [][] planoSala) {
        this.planoSala = planoSala;
    }

    public int getFilaOcupada() {
        return filaOcupada;
    }

    public void setFilaOcupada(int filaOcupada) {
        this.filaOcupada = filaOcupada;
    }

    public int getColumnaOcupada() {
        return columnaOcupada;
    }

    public void setColumnaOcupada(int columnaOcupada) {
        this.columnaOcupada = columnaOcupada;
    }

    
    @Override
    public String toString() {
        
        return "Sala :"+"nom=" + nom + ",\n aforament=" + aforament + ", files=" + files + ", columnes=" + columnes + ", \n pelicula=" + pelicula + ", preuEntrada=" + preuEntrada+"\n";
        
    }
    
    // MÈTODES -----------------------------------------------------------------
    public void mostrarPlanoSala(){
        for (int i=0; i<files; i++){
            for(int j=0; j<columnes; j++){
                if(planoSala[i][j]!=null){
                    System.out.print("-OC-");
                }else{
                    System.out.print(planoSala[i][j]);
                }
            }
            System.out.println("");
        }
        
    }
    
    public int mostrarEspectadorsSala(){
        int contador=0;
        
        for (int i=0; i<files; i++){
            for(int j=0; j<columnes; j++){
                if(planoSala[i][j]!=null){
                    System.out.println(" ["+planoSala[i][j]+"] ");
                    contador++;
                }
            }
            
        }
        
        return contador;
    }
    
    public void afegirEspectador(Espectador espectador){
        
        // determinem si superem l'aforament de la sala
        if(entradesVenudes > aforament){
            
          System.out.println("L'aforament no permet més espectadors ");
          
        } else if (columnaOcupada>(columnes-1) & filaOcupada<(files-1)){
            columnaOcupada=0;
            filaOcupada++;            
        }
       
        // incremento les entrades venudes, insereixo l'espectador al seu lloc i actualitzo la columna.
        entradesVenudes++;
        planoSala[filaOcupada][columnaOcupada]=espectador;
        columnaOcupada++; 
    }    
}
