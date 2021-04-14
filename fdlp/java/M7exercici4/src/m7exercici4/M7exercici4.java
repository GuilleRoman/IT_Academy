/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici4;

import static java.lang.Double.isNaN;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * M7exercici4
 * 
 * @author juanjo Campos 
 */
public class M7exercici4 {
    
    public static ArrayList<Edifici> edificis = new ArrayList();

    /**
     * main()
     * 
     * @param args  -no arguments-
     */
    public static void main(String[] args) {
         // Declaració de variables ---------------------------------------------
        Boolean sortir=false;        // Testimoni per sortir del menú general.
        Boolean sortir1n=false;     // Testimoni per sortir del menu secundari (operativa compte c.).
        int opcio;                 //opció del menú general.
        int existeix=-1;          // recull si un edifici existeix (n) o no (-1)  
        String nomEdifici;       // variable per treballar amb el nom d'edifici.
        
        Edifici nouEdifici=null;
        Hospital nouHospital=null;
        Hotel nouHotel=null;
        Cinema nouCinema=null;
        
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        // Menú principal ------------------------------------------------------
        System.out.println("---------- GESTIÓ D'EDIFICIS  fdlp ----------");
        while(!sortir){
            System.out.println("1.- Crear Edifici");
            System.out.println("2.- Eliminar Edifici");
            System.out.println("3.- Mostrar Edifici");           
            System.out.println("4.- Carregar dades de prova ");
            System.out.println("5.- Mostrar dades de prova");
            System.out.println("0.- Sortir");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1:  //Crear edifici ---------------------------------------
                    sortir1n=false;
                    
                    System.out.println("---------- ALTA D'EDIFICI  fdlp ----------");
                    while(!sortir1n){
                        System.out.println("1.- Hospital");
                        System.out.println("2.- Hotel");
                        System.out.println("3.- Cinema");
                        System.out.println("0.- Sortir");
                        System.out.print("Tria l'opció :");
                        opcio=lector.nextInt();
                        
                        switch(opcio){
                            case 1:  //Crear hospital---------------------
                                
                               nouEdifici=demanarDadesEdifici("hospital"); 
                               
                               if (cercarEdifici(nouEdifici.getNom())==-1){
                                    nouHospital=(Hospital)nouEdifici;
                                    edificis.add(nouHospital);
                                    System.out.println("El nou hospital ha estat creat correctament ");
                               }else{
                                   System.out.println("ATENCIÓ: l' hospital ja existeix ! ");
                               }     
                               
                               break;
                            case 2:  //Crear hotel --------------------
                                
                               nouEdifici=demanarDadesEdifici("hotel"); 
                               
                               if (cercarEdifici(nouEdifici.getNom())==-1){
                                    nouHotel=(Hotel)nouEdifici;
                                    edificis.add(nouHotel);
                                    System.out.println("El nou hotel ha estat creat correctament ");
                               }else{
                                   System.out.println("ATENCIÓ: l' hotel ja existeix ! ");
                               }
                               
                               break;
                            case 3:  //Crear cinema----------------------
                                
                                nouEdifici=demanarDadesEdifici("cinema");
                                
                               if (cercarEdifici(nouEdifici.getNom())==-1){
                                    nouCinema=(Cinema)nouEdifici;
                                    edificis.add(nouCinema);
                                    System.out.println("El nou cinema ha estat creat correctament ");
                               }else{
                                   System.out.println("ATENCIÓ: el cinema ja existeix ! ");
                               }
                               
                               break;
                            case 0: // sortir.
                                sortir1n=true;
                                break;
                            default:// Opció incorrecta.
                                System.out.println("Opció incorrecta, torna a triar [0..3]");   
                        } //switch
                    } //while   
                    break;
                    
                case 2:  //eliminar edifici ------------------------------
                    
                    //Demanem el nom de l'edifici     metode demanarString
                    nomEdifici=demanarString("Nom de l'edifici : ");
                    
                    // Cerquem l'edifici a l'ArrayList, si no existeix missatge d'error
                    existeix=cercarEdifici(nomEdifici);
                    if (existeix==-1){
                        System.out.println("ERROR: L'edifici no existeix ");
                    }else{
                        edificis.remove(existeix);
                        System.out.println("L'edifici ha estat eliminat satisfactoriament ");
                    }
                    break;
                    
                case 3: //mostrar edifici
                    
                    //Demanem el nom de l'edifici     metode demanarString
                    nomEdifici=demanarString("Nom de l'edifici : ");
                    
                    // Cerquem l'edifici a l'ArrayList, si no existeix missatge d'error
                    existeix=cercarEdifici(nomEdifici);
                    if(existeix!=-1){
                        if(edificis.get(existeix) instanceof Hospital){
                            nouHospital=(Hospital)edificis.get(existeix);
                            nouHospital.netejar();
                            nouHospital.calcularCostVigilancia();
                            nouHospital.repartirDinar();
                        }else if (edificis.get(existeix) instanceof Hotel){
                            nouHotel=(Hotel)edificis.get(existeix);
                            nouHotel.netejar();
                            nouHotel.calcularCostVigilancia();
                            nouHotel.costServeiHabitacions();
                        }else if(edificis.get(existeix) instanceof Cinema){
                            nouCinema=(Cinema)edificis.get(existeix);
                            nouCinema.netejar();
                            nouCinema.calcularCostVigilancia();
                            nouCinema.projectarSessio(50, 9.20);
                        }    
                        
                    }else{
                        System.out.println("ATENCIO: l' edifici cercat no existeix ");
                    } 
                       
                    break;
                case 4:  //carregar dades prova
                    crearDadesInicials();
                    break;
                case 5: //mostrar totes les dades
                    motrarTotesLesDades();
                    break;    
                case 0: // sortir.
                    sortir=true;
                    break;
                default:// Opció incorrecta.
                    System.out.println("Opció incorrecta, torna a triar [0..5]");
            } //switch       
        }//while
        
        
    }//main
    
    
    /**
     * cercarEdifici
     * 
     * Cerca un edifici pel seu nom i retorna el lloc que ocupa a l'array o -1 si no existeix.
     * 
     * @param       nom     String   nom de l'edifici
     * @return      index   int      n   si existeix retorna l'index que ocupa
     *                              -1   Si no existeix l'edifici. 
     */
    public static int cercarEdifici(String nom){
        int index=-1; 
        
        for(int i=0;i<edificis.size();i++){
            if(edificis.get(i).getNom().equals(nom)){
                index=i;
                break;
            }
            
        }
        
        return index;
    }
    
    
    
    
    /**
     * demanarString
     * 
     * Demana un string via teclat
     * 
     * @param   missatge    String  missatge a demanar.
     * @return  nom         String  Retorna l'entrada per teclat
     */
    public static String demanarString(String missatge){
        Boolean iterar=true;
        String nom="";
        // Objecte Scanner per llegir de teclat.
        Scanner lector=new Scanner(System.in);
        
        
        // Demano l'string 
        while(iterar){
            System.out.print(missatge+" : ");
            nom = lector.nextLine();
            
            if(nom.length() > 3){
                iterar=false;
            }
        }
        
        return nom;
    }
    
    
    
    public static Edifici demanarDadesEdifici(String tipus){
        //Declaració de variables ----------------------------------------
        Boolean iterar=true;       // Testimoni iteraració dels bucles while.
        int plantes=0;            // recull el nombre de plantes que té l'edifici.
        int superficie=0;        // recull els metres quadrats que té l'edifici.        
        int llits=0;            // recull els llits totals que té l'hospital.
        int llitsOcupats=0;    // recull els llits de l'hospital ocupats via teclat.
        int habitacions=0;    // recull les habitacions de l'hotel via teclat.
        int aforament=0;      // recull l'aforament del cinema via teclat
        Edifici nouEdifici = null;  // var edifici que retorna l'objecte creat.
        String nom;
        
        
        // Objecte Scanner per llegir de teclat.
        Scanner lector=new Scanner(System.in); 
        
        //Dades de la superClasse ------------------
        
        // Demano el nom de l'edifici
        nom=demanarString("nom del "+tipus+" : ");
        
        
        // Demano les plantes 
        while(iterar){
            System.out.print("Numero de plantes : " );
            plantes=lector.nextInt();
                       
            if(!isNaN(plantes) && plantes>0){
                iterar=false;
            }
        }
        
        // Demano la superfície         
        iterar=true;
        while(iterar){
            System.out.print("Superficie (m2) : " );
            superficie=lector.nextInt();
                       
            if(!isNaN(superficie) && superficie>0){
                iterar=false;
            }
        }
        
        //Demano les dades específiques de l'edifici--------------------
        switch(tipus){
            case "hospital":
                // Demano el total de llits de l'hospital         
                iterar=true;
                while(iterar){
                    System.out.print("Total de llits de l'hospital : " );
                    llits=lector.nextInt();

                    if(!isNaN(llits) && llits>0){
                        iterar=false;
                    }
                }
                
                // Demano el nombre de llits ocupats de l'hospital         
                iterar=true;
                while(iterar){
                    System.out.print("Nombre de llits ocupats : " );
                    llitsOcupats=lector.nextInt();

                    if(!isNaN(llitsOcupats) && llitsOcupats>0){
                        iterar=false;
                    }
                }
                
                //Creo l'objecte Hospital
                Hospital nouHospital = new Hospital(nom,plantes,superficie,llitsOcupats,llits);
                nouEdifici=(Edifici)nouHospital;
                break;               
                
            case "hotel":
                
                // Demano el total d'habitacions de l'hotel        
                iterar=true;
                while(iterar){
                    System.out.print("Total d'habitacions de l'hotel : " );
                    habitacions=lector.nextInt();

                    if(!isNaN(habitacions)){
                        iterar=false;
                    }
                }
                
                //Creo l'objecte Hotel
                Hotel nouHotel = new Hotel(nom,plantes,superficie, habitacions);
                nouEdifici=(Edifici)nouHotel;
                
                break;
            case "cinema":
                
                // Demano l'aforament total del cinema        
                iterar=true;
                while(iterar){
                    System.out.print("Aforament total del cinema : " );
                    aforament=lector.nextInt();

                    if(!isNaN(aforament)){
                        iterar=false;
                    }
                }
                
                //Creo l'objecte Cinema
                Cinema nouCinema = new Cinema(nom,plantes,superficie, aforament);
                nouEdifici=(Cinema)nouCinema;
                
                break;
            default:
                System.out.println("ERROR: Mètode: demanarDadesEdifici,  El tipus passat com a paràmetre no existeix ");
        }        
        
       return nouEdifici;
    }
    
    /**
     * crearDadesInicials
     * 
     * Crea 3 hospitals, 3 hotels i 3 cinemes  per fer les proves de funcionament.
     */
    public static void crearDadesInicials(){
        //---------- Definició de variables 
        Hospital hospi;
        Hotel hotel;
        Cinema cinema;
        
        
        // "Hospital de Vilafranca”, de 1.950 m² i 2 plantes. En aquest moment té 26 malalts i 80 llits totals.
        hospi = new Hospital("Hospital de Vilafranca", 2, 1950, 26, 80);
        edificis.add(hospi);
        
        //Hospital General de Catalunya”, de 25.350 m² i 10 plantes. En aquest moment té 315 malalts i 500 llits.
        hospi = new Hospital("Hospital General de Catalunya", 10, 23350, 315, 500);
        edificis.add(hospi);
        
        //Hospital de Terrassa”, de 35.350 m² i 10 plantes. En aquest moment té 315 malalts.
        hospi = new Hospital("Hospital de Terrassa", 2, 35350, 110, 250);
        edificis.add(hospi);
        
        
        //El “Cinema Montecarlo”, de  3180 m² i 1 planta, aforament de 1050 places.
        cinema = new Cinema("Cinema Montecarlo", 1, 3180,1050);
        edificis.add(cinema);
        
        //El “Cinema Principal”, de 12.450 m² i 2 plantes i aforament de 3000 places.
        cinema = new Cinema("Cinema Principal", 2, 12450, 3000);
        edificis.add(cinema);
        
        //El Cinema Paradise, de 32.350 m i 3 plantes i aforament de 5000 places.
        cinema = new Cinema("Cinema Paradiso", 3, 32350,5000);
        edificis.add(cinema);
        
        
        //L’”Hotel Hilton catalonia”, de 73.858 m² i 22 plantes. Té 583 habitacions.
        hotel = new Hotel("Hotel Hilton Catalonia", 22, 73858,583);
        edificis.add(hotel);
        
        //L’”Hotel Les Lloses”, de 593 m² i 3 plantes. Té 12 habitacions. 
        hotel = new Hotel("Hotel Les Lloses", 3, 593, 12);
        edificis.add(hotel);
        
        System.out.println("Les dades han estat carregades correctament.");
        
    }//crearDadesInicials
    
    public static void motrarTotesLesDades(){
        System.out.println("---------- Relació d'edificis ----------");
        for(int i=0;i<edificis.size();i++){
            String dades=edificis.get(i).toString();
            System.out.println("----------------------------------------");
            System.out.println(dades);
        }
       
        System.out.println("----------------------------------------");
    }
    
}
