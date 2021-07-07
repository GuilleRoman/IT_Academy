/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * M7 exercici extra   Ruleta Russa.
 */
package m7ruletarussa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Juan José Campos Caballero.
 */
public class Joc {
    // propietats ----------------------------------------
    private ArrayList<Jugador> jugadors = new ArrayList();
    private Revolver revolver;
    private Boolean mort;
    
    // Constructors ----------------------------------------
    public Joc(ArrayList<Jugador> jugadors, Revolver revolver) {
        this.revolver = revolver;
        this.jugadors=jugadors;
        mort=false;
    }
    
    // Getters, Setters, i toString --------------------------

    public ArrayList<Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(ArrayList<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    public Revolver getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver revolver) {
        this.revolver = revolver;
    }

    @Override
    public String toString() {
        return "Joc{\n" + "jugadors= " + jugadors + ", \nrevolver=" + revolver + "}";
    }
    
    // Mètodes ----------------------------------------------
    
    /**
     * finalJoc()
     * 
     * @return  mort    Boolean     true : Ha mort algú al joc 
     */
    public Boolean finalJoc(){
     
        return mort;
    }
    
    
    
    /**
     * ronda()
     * 
     */
    public void ronda(){
        int index=0;             // index array de  jugadors  
        int trets=0;
        float probabilitat;
        Boolean disparat;      // recull el resultat del tret.
        
        System.out.println("------------------------------");
        System.out.println("El joc comença amb "+jugadors.size()+" jugadors ");
        System.out.println("------------------------------");
        
        do{                      
            if(index==jugadors.size()){ index=0; } 
                                  
            dibuixa(jugadors.get(index).getNombre()+"  [ "+jugadors.get(index).getNickName()+" ]");                      
            
            disparat=revolver.disparar();
            
            if(disparat==true){ 
                System.out.println("El revolver ha disparat la bala, i "+jugadors.get(index).getNombre()+" amb el malnom de "+jugadors.get(index).getNickName()+" ha estat exitus !!!!!");
                this.mort=true;
            }else{               
                index++;  //Actualitzo el jugador
                revolver.siguienteBala(); //Actualitzo el tambor del revolver                
            }
        }while(!mort);        
    }
    
    
    public void dibuixa(String jugador){
        int pa=revolver.getPosicioActual();
        int pb=revolver.getPosicioBala();
        
        String[] tambor = new String[6];       
       
        for(int i=0; i<6; i++){           
            if (i==pb & i==pa){
                tambor[i]="[RIP ]";
            } else if (i==pa){
                tambor[i]="[ Pa ]";
            } else if (i==pb){
                tambor[i]="[ Pb ]";
            } else {
                tambor[i]="[ -- ]";
            }            
        }
        
        System.out.println(Arrays.toString(tambor)+"  "+jugador);        
    }
    
    
    
    
    
}
