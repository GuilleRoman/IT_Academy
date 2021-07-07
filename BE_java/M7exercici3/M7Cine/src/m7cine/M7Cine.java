/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7cine;

import static java.lang.Double.isNaN;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juanj
 */
public class M7Cine {
    
  

// Array on emma. els diferents cinemes.
public static ArrayList<Cinema> cinemes = new ArrayList();
public static ArrayList<Espectador> espectadors = new ArrayList();

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
    // Definició de variables
    int files=0;                 // files de la sala de un cinema.
    int columnes=0;             // Columnes de la sala de un cinema.
    int opcio;                 // var switch menú nivell 0.
    int opcio1;               // var switch menú nivell 1.
    int existeix;            // existeix Cinema
    int existeixSala;       // existeix Sala 
    int indexCinema=-1;    // index del cinema actiu
    int indexSala=-1;     // index de la sala activa
    int indexEspectador; // index de l'espectador actiu
    int nombreEntrades; // nombre d'entrades venudes a una sala
    double nouMoneder;  // Import del moneder després de fer la compra d'una entrada 
    
    Boolean sortir=false;
    Boolean sortir1n=false;
    
    String nomSala="";      // Nom de la sala. 
    
    Sala sala=null;              // Obj. Sala.
    Cinema cine=null;           // Obj. Cinema.
    Espectador espectador;     // Obj. Espectador.
    
        
    Scanner lector= new Scanner(System.in); 
    
    // Menú principal ------------------------------------------------------
        System.out.println("GESTIÓ DE CINEMES    IT_ACADEMY fdlp");
        while(!sortir){
            System.out.println("-------- CINEMA --------");
            System.out.println("1.- Crear Cinema");
            System.out.println("2.- Eliminar Cinema");  
            System.out.println("3.- Mostrar dades del cinema");
             
            System.out.println("--------  SALA  --------");
            System.out.println("4.- Afegir sala a Cinema ");
            System.out.println("5.- Esborrar sala a Cinema ");
            System.out.println("-------- TAQUILLA --------");
            System.out.println("6.- Gestió d'entrades ");
            System.out.println("7.-  ");
            System.out.println("8.-  ");
            System.out.println("-------- CLIENTS --------");
            System.out.println("9.- Carregar dades de prova ");
            
            
            System.out.println("0.- Sortir");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1: // Crear Cinema ----------------------------------------
                    // Demana el nom del cinema
                    nomSala=demanarString("Indica el nom del cinema (mínim 3 caràcters) : ");
                    
                    //Determino si existeix
                    existeix=existeixCine(nomSala);
                    if (existeix!=-1){
                        System.out.println("Atenció : el cinema ja existeix ");
                    } else {                         
                        // Creem lobjecte Cinema.
                        cine = new Cinema(nomSala);
                        
                        //emma. el cinema a l'array de cinemes.
                        cinemes.add(cine);
                        
                        System.out.println("El Cinema "+nomSala+" Ha estat creat satisfactoriament i emmagatzemat.");
                    }    
    
                    break;    
                case 2:// Eliminar Cinema --------------------------------------
                    // Demana el nom del cinema
                    nomSala=demanarString("Indica el nom del cinema (mínim 3 caràcters) : ");
                    
                    //Determino si existeix
                    existeix=existeixCine(nomSala);
                    if (existeix==-1){
                        System.out.println("Atenció : el cinema a esborrar no existeix ");
                    } else {                         
                        //esborrem el cinema a l'array de cinemes.
                        cinemes.remove(existeix);
                        
                        System.out.println("El Cinema "+nomSala+" Ha estat esborrat satisfactoriament");
                    }    
                    break;
                    
                case 3:// Mostrar dades de cinema ------------------------------
                    for(int i=0; i<cinemes.size(); i++){
                        System.out.println(cinemes.get(i).toString());
                        
                    }
                    break;
                    
                case 4:// Afegir Sala a Cinema ---------------------------------
                        
                    //Mostrem els cinemes existents.
                    mostrarCinemes();
                    
                    //Seleccionem el cinema 
                    nomSala=demanarString("Indica el nom del cinema a afegir sala (mínim 3 caràcters) : ");
                    
                    // Determinem si existeix
                    existeix=existeixCine(nomSala);
                    if(existeix!=-1){
                        System.out.println("Cinema :"+cinemes.get(existeix).getNom());
                        nomSala=demanarString("Nom de la sala a crear : ");
                        
                        //Determinem si existeix la sala al cinema seleccionat.
                        existeixSala=cercarSala(existeix, nomSala);
                        if(existeixSala==-1){
                            //Creo la sala
                            files = numInteger("Nombre de files de la sala : ");
                            columnes = numInteger("Nombre de columnes de la sala : ");        
                            sala = new Sala(nomSala,files, columnes);
                            
                            //Afegeixo la sala a l'ArrayList
                            cinemes.get(existeix).getSales().add(sala);
                            System.out.println("La sala ha estat creada satisfactoriament ");
                            
                        }else{
                            System.out.println("Atenció: La sala ja existeix ");
                        }
                        
                    } else {
                        System.out.println("Atenció: el cinema introduit no existeix ");
                    }
                    
                    break;
                
                case 5:// Esborrar sala a cinema -------------------------------
                    //Mostrem els cinemes existents.
                    mostrarCinemes();
                    
                    //Seleccionem el cinema 
                    nomSala=demanarString("Indica el nom del cinema a eliminar sala (mínim 3 caràcters) : ");
                    
                    // Determinem si existeix
                    existeix=existeixCine(nomSala);
                    if(existeix!=-1){
                        System.out.println("Cinema :"+cinemes.get(existeix).getNom());
                        nomSala=demanarString("Nom de la sala a eliminar : ");
                        
                        //Determinem si existeix la sala al cinema seleccionat.
                        existeixSala=cercarSala(existeix, nomSala);
                        if(existeixSala!=-1){
                            
                            //Esborro la sala de l'ArrayList
                            cinemes.get(existeix).getSales().remove(existeixSala);
                            System.out.println("La sala ha estat esborrada ");
                            
                        }else{
                            System.out.println("Atenció: La sala no existeix ");
                        }
                        
                    } else {
                        System.out.println("Atenció: el cinema introduit no existeix ");
                    }                    
                    break;
                case 6:// Gestió d'entrades ------------------------------------
                    System.out.println("GESTIÓ D'ENTRADES");
                    while(!sortir1n){                        
                        System.out.println("1.- Seleccionar Cinema i sala");
                        System.out.println("2.- Vendre entrades");
                        System.out.println("3.- Cancelar entrada");  
                        System.out.println("4.- Mostrar entrades venudes");
                        System.out.println("5.- Llista d'espectadors i recaudació");
                        System.out.println("0.- Sortir");
                        System.out.print("Tria l'opció :");
                        opcio1=lector.nextInt();

                        switch(opcio1){
                            case 1:// Seleccionar el cinema a treballar --------
                                //Mostrem els cinemes existents.
                                mostrarCinemes();
                                do{                                
                                    indexCinema = numInteger("Selecciona el número de cinema : ");
                                } while(indexCinema<0 || indexCinema>cinemes.size());
                                
                                //Mostrem les sales 
                                mostrarSales(indexCinema);
                                do{                                
                                    indexSala = numInteger("Selecciona el número de sala : ");
                                    System.out.println(""+indexCinema);
                                } while(indexCinema<0 || indexCinema>cinemes.size());
                                
                                // Mostrem cinema i sala
                                System.out.println ("-----------------------------------------------");
                                System.out.print(cinemes.get(indexCinema).getNom()+"   ");
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getNom());
                                
                                // Mostrem dades de pel.licula i preu 
                                System.out.print(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getTitulo()+"  ");
                                System.out.print(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getDuracio()+"  ");
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getEdatMitjana()+"  ");
                                
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada()+" euros" );
                                System.out.println ("-----------------------------------------------");
                                
                                break;
                            case 2:// Vendre Entrades. -----------------------------------
                                //Mostrar els clients o Demanar un client nou
                                mostrarEspectadors();
                                
                                
                                
                                do{  
                                    System.out.println("espectador size " + espectadors.size());
                                    indexEspectador = numInteger("Selecciona el número de client, o ("+espectadors.size()+") per afegir un espectador nou : ");
                                } while(indexEspectador<0 || indexEspectador>espectadors.size());
                                
                                
                                System.out.println("----> index esp "+indexEspectador+"   Size  "+espectadors.size());
                                if(indexEspectador==espectadors.size()){
                                    espectador=crearEspectador();
                                    espectadors.add(espectador);
                                    indexEspectador=espectadors.size();
                                } else {
                                  espectador=espectadors.get(indexEspectador);
                                }
                                
                                // Si l'espectador té prous diners per comprar l'entrada 
                                if (espectador.getMonedero()>=cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada()){
                                   if(espectadors.get(indexEspectador).getEdat() > cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getEdatMitjana()){
                                           
                                    //Actualitzo el moneder
                                    nouMoneder= espectadors.get(indexEspectador).getMonedero()-cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada();
                                    espectadors.get(indexEspectador).setMonedero(nouMoneder);
                                    
                                    //Insereixo l'espectador a la sala
                                    cinemes.get(indexCinema).getSales().get(indexSala).afegirEspectador(espectador);
                                    System.out.println("Entrada venuda correctament");
                                    generarEntrada(indexCinema, indexSala);
                                   } else {
                                       System.out.println("L'espectador "+ espectador.getNom()+" no té prou edat per mirar aquesta pel·licula.");
                                   }
                                } else {
                                    System.out.println("L'espectador "+ espectador.getNom()+" no té prou diners per comprar l'entrada.");
                                } 
                                break; 
                                
                            case 3:// Sortir -----------------------------------
                                
                                break; 
                                
                            case 4:// Mostrar sala amb entrades venudes-------------------------------
                                // Mostrem cinema i sala
                                System.out.println ("-----------------------------------------------");
                                System.out.print(cinemes.get(indexCinema).getNom()+"   ");
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getNom());
                                
                                // Mostrem dades de pel.licula i preu 
                                System.out.print(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getTitulo()+"  ");
                                System.out.print(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getDuracio()+"  ");
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getEdatMitjana()+"  ");
                                
                                System.out.println(cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada()+" euros" );
                                System.out.println ("-----------------------------------------------");
                                
                                cinemes.get(indexCinema).getSales().get(indexSala).mostrarPlanoSala();
                                
                                break;        
                            
                            case 5:// Espectadors i recaudació -----------------------------------
                                nombreEntrades=cinemes.get(indexCinema).getSales().get(indexSala).mostrarEspectadorsSala();
                                System.out.println("Entrades venudes :"+nombreEntrades+" preu de l'entrada : "+cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada());
                                System.out.println("Total de la recaudació de la sala : "+(nombreEntrades*cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada())+" euros.");
                                break;    
                            case 0:// Sortir -----------------------------------
                                sortir1n=true;
                                break;    
                            default:        
                                System.out.println("Opció incorrecta, torna a triar [0..4] ");
                        }
                    }
                    
                    break;    
                case 9:// Carregar dades de prova ------------------------------
                    carregarDadesProva();
                    break;
                    
                case 0:// Sortir -----------------------------------------------
                    sortir=true;
                    break;
                
                default: // Default --------------------------------------------
                    System.out.println("Opció incorrecta, torna a triar [0..5]");                    
            }
        }
}

// ------------------ MÈTODES --------------------------------------------------
    
    public static void carregarDadesProva(){
        Cinema cine;
        Sala sala;
        Pelicula pelicula;
        
        // ----------------------------------------------
        cine = new Cinema("Cinemes Yelmo");
        sala = new Sala("Sala 1", 3, 4);
        String peli="Rampusel";
        String auth="Roman Polansky";
        pelicula = new Pelicula (peli,89,16,auth);               
        cine.afegirSala(sala);
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(8.25);
        
                
        sala = new Sala("Sala 2", 10, 10);
        pelicula = new Pelicula("Sense tu", 89, 16, "Eva Sabater");
        cine.afegirSala(sala);
        cine.getSales().get(1).setPelicula(pelicula);
        cine.getSales().get(1).setPreuEntrada(9.25);
        
        sala = new Sala("Sala 3", 10, 10);
        pelicula = new Pelicula("Sense tu 2a part", 89, 16, "Eva Sabater");
        cine.afegirSala(sala); 
        cine.getSales().get(2).setPelicula(pelicula);
        cine.getSales().get(2).setPreuEntrada(9.25);
        cinemes.add(cine);
        
        // ------------------------------------------------------------        
        cine = new Cinema("Cinemes Tarraco");
        sala = new Sala("Sala 1", 10, 10);
        pelicula = new Pelicula("Sense tu", 89, 16, "Eva Sabater");
        cine.afegirSala(sala); 
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(8.25);        
        
        
        
        pelicula = new Pelicula("Barri", 89, 16, "A Gimpferrer");
        sala = new Sala("Sala 2", 5, 10);
        cine.afegirSala(sala); 
        cine.getSales().get(1).setPelicula(pelicula);
        cine.getSales().get(1).setPreuEntrada(8.25);        
        
        
        pelicula = new Pelicula("Bona gent", 89, 16, "A. Vilamata");
        sala = new Sala("Sala 3", 5, 10);
        cine.afegirSala(sala); 
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(11.25);        
        cinemes.add(cine);
        
        // -----------------------------------------------------------------
        
        cine = new Cinema("Cinemes Xirinacs");        
        sala = new Sala("Sala 1", 10, 10);
        cine.afegirSala(sala); 
        pelicula = new Pelicula("Rampusel2 the retorn", 100, 13, "R Zamenhoff");
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(8.25);
        cinemes.add(cine);
        
        // ---------------------------------------------------------------------
        cine = new Cinema("Cinemes Novetats");
        sala = new Sala("Sala 1", 10, 10);
        pelicula = new Pelicula("El pianista", 150, 18, "Roman Polansky");
        cine.afegirSala(sala); 
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(9.25);
        cinemes.add(cine);
        
        //----------------------------------------------------------------------
        cine = new Cinema("Cinemes Cinesa");
        sala = new Sala("Sala 1", 10, 10);
        pelicula = new Pelicula("El llorer màgic", 120, 3, "Pita Colita");
        cine.afegirSala(sala); 
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(4.25);        
        cinemes.add(cine);
        
        //----------------------------------------------------------------------
        cine = new Cinema("Cinemes Garrotxins");
        sala = new Sala("Sala 1", 10, 10);
        pelicula = new Pelicula("La milla verde", 116, 18, "P. Hustinoff");
        cine.afegirSala(sala); 
        cine.getSales().get(0).setPelicula(pelicula);
        cine.getSales().get(0).setPreuEntrada(9.15);        
        cinemes.add(cine);
        
        
        // Creo els Espectadors
        Espectador espectador ;
        
        espectador = new Espectador("Mercè Salas", 55,25.30);
        espectadors.add(espectador);        
        
        espectador = new Espectador("Joan Manuel", 34 ,12.50);
        espectadors.add(espectador);
        
        espectador = new Espectador("Manoli Moreno", 41,200.50);
        espectadors.add(espectador);
        
        espectador = new Espectador("Pere Camprubí", 11 , 3.30);
        espectadors.add(espectador);
        
        espectador = new Espectador("iolanda Jolonc",23 ,25.04);
        espectadors.add(espectador);
        
        espectador = new Espectador("josep Jolonc",23 ,25.04);
        espectadors.add(espectador);
        
        espectador = new Espectador("Lourdes Blanc",32 ,25.04);
        espectadors.add(espectador);
        
        
        // Afegeixo espectadors a la sala 1 del cinema yelmo [0][0]
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(0));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(1));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(2));
        
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(3));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(4));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(5));
        
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(6));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(0));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(1));
        
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(2));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(3));
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(4));
        
        cinemes.get(0).getSales().get(0).afegirEspectador(espectadors.get(5));
        
        System.out.println("Les dades de prova han estat carregades ...............");
    }
    
    public static void generarEntrada(int indexCinema,int indexSala){
        System.out.println("ENTRADA --------------------------------------------");
        System.out.println(cinemes.get(indexCinema).getNom());
        
        System.out.print(" Sala : "+cinemes.get(indexCinema).getSales().get(indexSala).getNom());
        System.out.print("  Fila : "+cinemes.get(indexCinema).getSales().get(indexSala).getFilaOcupada());
        System.out.println("  Seient : "+cinemes.get(indexCinema).getSales().get(indexSala).getColumnaOcupada());
        
        System.out.println(" Pelicula : "+cinemes.get(indexCinema).getSales().get(indexSala).getPelicula().getTitulo());
        
        System.out.print(" Preu Entrada : "+cinemes.get(indexCinema).getSales().get(indexSala).getPreuEntrada());
        System.out.println("----------------------------------------------------");
    }
    
    public static Espectador crearEspectador(){
        String nom;
        int edat;
        double doblers;
        Espectador espectador = null;
        Boolean iterar=true;
        
        while(iterar){
            System.out.println("Afegir nou espectador :");
            System.out.println("-----------------------");
            
            nom=demanarString("- Nom de l'espectador : ");

            if(existeixEspectador(nom)==-1){
         
                iterar=false; 
                edat=numInteger("- Edat : ");        
                doblers=(double)numInteger("- monedero : ");
                espectador = new Espectador(nom,edat,doblers);

            } else {

                System.out.println("El client ja existeix");

            }        
        }
                
        return espectador;
    }
    
    
    public static int cercarSala(int index, String nomS){
        int existeix=-1;
        
        
        for (int i=0; i<cinemes.get(index).getSales().size(); i++){           
            if(cinemes.get(index).getSales().get(i).getNom().equals(nomS)){
                existeix=i;
                break;
            }
        }
        return existeix;
    }
    
    public static void mostrarEspectadors(){
        System.out.println("Relació d'espectadors : ");
        System.out.println("------------------------");
        
        for(int i = 0; i<espectadors.size(); i++){
            System.out.println(i+"- "+espectadors.get(i).toString());
        }
        
    }
    
    public static void mostrarCinemes(){
        System.out.println("Relació de cinemes : ");
        System.out.println("---------------------");
        
        for(int i=0;i<cinemes.size(); i++){
            System.out.println(i+"- "+cinemes.get(i).getNom());
        }
    }
    
    public static void mostrarSales(int index){
        System.out.println("Relació de sales : ");
        System.out.println("---------------------");
        for (int i=0; i<cinemes.get(index).getSales().size(); i++){
            System.out.println(i+"- "+cinemes.get(index).getSales().get(i).getNom());
        }
    }


    public static int existeixCine(String nomCinema){
        int existeix = -1;
        for(int i=0;i<cinemes.size();i++){
            if(cinemes.get(i).getNom().equals(nomCinema)){
               existeix=i; 
               break; 
            }
        }
        return existeix;
    }

    
    public static int existeixEspectador(String nomEspectador){
        int existeix = -1;
        for(int i=0;i<espectadors.size();i++){
            if(espectadors.get(i).getNom().equals(nomEspectador)){
               existeix=i; 
               break; 
            }
        }
        return existeix;
    }
    
    
    public static String demanarString(String missatge1){
        String cadena="";
        Boolean iterar=true;
        Scanner lector= new Scanner(System.in); 
            
        // Demano el nom de la sala
        do{                
           System.out.print(missatge1);
           cadena = lector.nextLine();

           if(cadena.length() >= 3){
                 iterar=false;
           }
        }while(iterar);
            
        return cadena;
    }    


    public static int numInteger(String missatge2){
           Boolean iterar=true;
           int valor = 0;
           Scanner lector= new Scanner(System.in); 
           
            while(iterar){
                System.out.print(missatge2);
                valor=lector.nextInt();

                if(!isNaN(valor) && valor>=0){
                    iterar=false;
                }
            } 
        return valor;   
    }
    
}



