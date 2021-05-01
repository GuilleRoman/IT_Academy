/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7ruletarussa;

import static java.lang.Double.isNaN;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author juanj
 */
public class M7RuletaRussa {
   
    
    //objecte Scanner per llegir del teclat.        
    public static Scanner lector = new Scanner(System.in);    

    /**
     * @param args the command line arguments
     */     
    public static void main(String[] args) {
        // Declaració de variables --------------------------------------------
        ArrayList<Jugador> jugadors = null;              //ArrayList de Jugadors
        Revolver revolver = null;            // objecte revolver 
        Jugador jugador=null;                         // Obj Jugador  
        Joc joc=null;                                // Obj joc
        String nomJugador="";                       // Nom del jugador
        char tornarJugar=0;                        // Caracter que recull de teclat 's' o 'n'
        int idNum;    //id de jugador           // Index del jugador
        Boolean jugarMes=true;                   // Testimoni per iterar en el joc
        
        while (jugarMes){
            
            // inicialitzem el revolver i l'array de jugadors i idNum (IdJugador)
            revolver = new Revolver();
            jugadors = new ArrayList();
            idNum=0;
            
            // Demanem el nombre de jugadors (màxim de 6 i minim de 2)
            int numJugadors=demanarNumJugadors("Nombre de jugadors [1..6] : ", 6, 2);

            // Inserim les dades dels jugadors i els afegim l'ArrayList jugadors 
            for(int i=1; i<=numJugadors; i++){

                nomJugador=demanarCadena("nom del jugador número  "+idNum+" : ", 3, 15);
                idNum++;

                jugador = new Jugador(idNum,nomJugador);
                System.out.print("Creat el jugador "+jugador.getNombre()+"  "+jugador.getNickName());
                jugadors.add(jugador);
                System.out.println(" i inserit a l'array");
            }
                    
            revolver.informar();
            joc = new Joc(jugadors,revolver);        
            joc.ronda();
            
            tornarJugar = preguntaSN("KAMIKAZE!!! Vols tornar a jugar? (s/n) ");
            if(tornarJugar == 'N'){
                jugarMes = false;
            }
        }
    }
    
    /**
     * demanarCadena
     * 
     * Recull del teclat una cadena en forma de String
     * 
     * @param       missatge    String  Missatge a mostrar al demanar la cadena
     * @param       minim       int     mínim de caracters a introduir.
     * @param       maxim       int     màxim de caracters a introduir.
     * @return      nom         String  Cadena recollida del teclat
     */
    public static String demanarCadena(String missatge, int minim, int maxim){
        Boolean iterar=true;
        String nom="";
        
        // Objecte Scanner per llegir de teclat.
       lector=new Scanner(System.in); 
        
        // Demano el nom del client
        while(iterar){
            System.out.print(missatge);
            nom = lector.nextLine();
            
            if(nom.length() >= minim & nom.length()<=maxim){
                iterar=false;
            }
        }
        
        return nom;
    }
    
    
    public static char  preguntaSN(String missatge){
        Boolean iterar=true;
        char opcio = 0;
        
        // Objecte Scanner per llegir de teclat.
       lector=new Scanner(System.in); 
        
        // faig la pregunta s/n
        while(iterar){
            System.out.print(missatge);
            opcio = lector.next().charAt(0);
            
            
            if(Character.toUpperCase(opcio)=='S' || Character.toUpperCase(opcio)=='N'){
                iterar=false;
            }        
        }
        return Character.toUpperCase(opcio);
    }
       
        
    public static int demanarNumJugadors(String missatge, int maxim, int minim){
        Boolean iterar=true;
        int valor = 0;
        
        // Objecte Scanner per llegir de teclat.
        lector=new Scanner(System.in); 
                
        while(iterar){
            System.out.print(missatge);
            valor=lector.nextInt();
        
            if(!isNaN(valor) & valor<=maxim & valor>=minim ){
                iterar=false;
            }            
        }
        
        return valor;
    }
    
    
}
