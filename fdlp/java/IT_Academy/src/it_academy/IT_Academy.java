/*
 * IT ACADEMY 
 * Fonaments de la programació
 * POO
 */
package it_academy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author juanjo Campos Caballero
 */
public class IT_Academy {

    
    public static void main(String[] args) {
        
        // Declaració de variables ---------------------------------------------
            
        ArrayList <Hotel> hotels = new ArrayList();         // Matriu on emma. els objectes Hotel 
        
        boolean sortir=false;     //Testimoni del while. 
        boolean segur;     // Testimoni de si esta segur s/n
        
        String nomHotel;    // Nom del hotel
        String hotelStr;      //Dades dels hotels via .toString().
       
        int habitacions=0;  // habitacions de l'hotel
        int plantes=0;     //plantes de l'hotel
        int superficie=0; //Superficie de l'hotel
        int indexHotel;  //index que ocupa l'hotel a l'ArrayList.
        int opcio;      // recull l'opció triada del menú.
                
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        // Menú principal ------------------------------------------------------
        System.out.println("GESTIÓ HOTELERA IT_ACADEMY fdlp");
        while(!sortir){
            System.out.println("1.- Afegir nou hotel");
            System.out.println("2.- Modificar dades d'un hotel");
            System.out.println("3.- Esborrar un hotel");
            System.out.println("4.- Llistar tots els hotels");
            System.out.println("5.- Sortir");
            System.out.println("");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1:
                    // Demano les dades de l'hotel, el creem i l'afegim a l'arrayList.
                    hotels.add(demanarDades());                    
                    System.out.println("Hotel creat de forma correcta: ");
                    
                    // Recupero l'hotel i el mostrem per pantalla                    
                    hotelStr=hotels.get(hotels.size()-1).toString();
                    System.out.println(hotelStr);                    
                    break;
                case 2:
                    nomHotel=demanarNomHotel();
                    indexHotel=cercarHotel(hotels,nomHotel);
                    if(indexHotel==-1){
                        System.out.println("L'hotel introduit no existeix");
                    } else{
                        // Mostrem les dades actuals de l'hotel
                        hotelStr=hotels.get(indexHotel).toString();
                        System.out.println("DADES ACTUALS DE L'HOTEL :");
                        System.out.println(hotelStr);
                        
                        // Demanem les noves dades
                        System.out.println("Introdueix les noves dades :");
                        Hotel hotelRectificat=demanarDades();
                        
                        //Sustitueixo les dades de l'hotel per les noves
                        hotels.get(indexHotel).setNom(hotelRectificat.getNom());
                        hotels.get(indexHotel).setNombreHabitacions(hotelRectificat.getNombreHabitacions());
                        hotels.get(indexHotel).setNombrePlantes(hotelRectificat.getNombrePlantes());
                        hotels.get(indexHotel).setSuperficie(hotelRectificat.getSuperficie());
                        
                         // Mostrem les dades actuals de l'hotel
                        hotelStr=hotels.get(indexHotel).toString();
                        System.out.println("DADES RECTIFICADES DE L'HOTEL :");
                        System.out.println(hotelStr);
                        
                    } 
                    break;
                case 3:
                    //Determinem l'hotel a esborrar
                    nomHotel=demanarNomHotel();
                    indexHotel=cercarHotel(hotels,nomHotel);
                    
                    //Determinem si existeix
                    if(indexHotel==-1){
                        System.out.println("L'hotel introduit no existeix");
                    } else{
                         // Mostrem les dades actuals de l'hotel
                        hotelStr=hotels.get(indexHotel).toString();
                        System.out.println("HOTEL A ESBORRAR :");
                        System.out.println(hotelStr);
                        
                        //Demanem confirmació abans d'esborrar-lo
                        segur=estaSegur("Està segur que vol eliminar aquest hotel? (s/n) :");
                        
                        // Esborrem l'hotel seleccionat
                        if(segur){
                            hotels.remove(indexHotel);
                            System.out.println("L'hotel ha estat esborrat correctament.");
                        }                        
                    }
                    
                    break;
                case 4:
                    llistarHotels(hotels);                    
                    break;    
                case 5:                    
                    sortir=true;
                    break;
                default:
                    System.out.println("Opció incorrecta, torna a triar [1..4]");               
                    
            }            
        }
    }
    
    
    static void llistarHotels(List<Hotel> hotels){
        Iterator<Hotel> it=hotels.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        
    }
    
    
    /**
     * cercarHotel()
     * 
     * Retorna l'index que ocupa l'hotel dins del ArrayList o -1 si no existeix
     * 
     * @param hotels    List<hotels>
     * @param nomHotel  String amb el nom de l'hotel.
     * 
     * @return  i   integer si existeix el nom a la llista.
     *         -1   Si no existeix l'hotel a la llista.
     */
    static int cercarHotel(List<Hotel> hotels,String nomHotel){
        
        for(int i=0;i<hotels.size();i++){
            if(hotels.get(i).getNom().equals(nomHotel)){
                return i;
            }
        }
        return -1;   
    }
    
    
    /**
     * demanarDades()
     * 
     * Demana les dades per creau un hotel
     * 
     * @return nouHotel     Hotel 
     **/    
    static Hotel demanarDades(){
        
//Declarem les variables
        
        String nom,plantes, habitacions, superficie; 
        int plantesF,habitacionsF,superficieF;
                
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        //Demanem el nom de l'hotel        
        do{
            System.out.print("Nom de l'hotel :");
            nom=lector.nextLine();
        }while(nom.equals(""));
        
        
        // demanem el nombre d'habitacions
        do{
            System.out.print("Nombre d'habitacions :");
            habitacions=lector.nextLine();
        }while(isInteger(habitacions)==false);
        
        // demanem el nombre de plantes
        do{
            System.out.print("Nombre de plantes :");
            plantes=lector.nextLine();
        }while(isInteger(plantes)==false);
        
        //Demanem la superfície de l'hotel.
        do{
            System.out.print("Superfície :");
            superficie=lector.nextLine();
        }while(isInteger(superficie)==false);
        
        habitacionsF=Integer.parseInt(habitacions);
        plantesF=Integer.parseInt(plantes);
        superficieF=Integer.parseInt(superficie);
        
        //Creem l'objecte hotel 
        Hotel nouHotel=new Hotel(nom,habitacionsF,plantesF,superficieF);               
        
        return nouHotel;         
    }
    
    static String demanarNomHotel(){
        //Declaració de variables
        String nom;
        
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        //Demanem el nom de l'hotel        
        do{
            System.out.print("Nom de l'hotel :");
            nom=lector.nextLine();
        }while(nom.equals(""));
        
        return nom;
    }
    
    
    /*isInteger
    *
    * @param  cadena  String 
    * @return boolean true integer, false not a number.
    */
    static Boolean isInteger(String cadena){
        int numero=0;
        
        try{
            numero=Integer.parseInt(cadena);
            return true;
            
        }catch(NumberFormatException ex){
            return false;            
        }
    }    
    
    /**
     * estaSegur()
     * Procediment que pregunta segons el missatge passat 
     * i retorna true si resposta és S,s  o false si resposta és N,n
     * 
     * @param missatge
     * @return testimoni  true=S,s ; false=N,n 
     */
    static Boolean estaSegur(String missatge){
        //Declaració de variables
        char opcio;
        Boolean testimoni=false;
        Boolean iterar=true;
        Scanner lector= new Scanner(System.in);
        
        System.out.print(missatge);
        
        while(iterar) {
            opcio=lector.next().charAt(0);
            opcio=Character.toUpperCase(opcio);
            System.out.println(opcio);
            
            if(opcio=='S'){
                testimoni=true;
                iterar=false;
            }else if(opcio=='N'){
                testimoni=false;
                iterar=false;
            }
        }              
        
        return testimoni;
    }
}

    
        
