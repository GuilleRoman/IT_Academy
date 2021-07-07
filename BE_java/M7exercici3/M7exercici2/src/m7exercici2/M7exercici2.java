/*
 * IT ACADEMY
 * Fonaments de la programació  -POO-
 * Juan José Campos Caballero.
 */
package m7exercici2;

import static java.lang.Double.isNaN;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



/**
 *
 * @author JuanJo Campos Caballero
 */
public class M7exercici2 {

    // ArrayList amb tots els comptes corrents 
    public static ArrayList<CompteCorrent> comptes = new ArrayList();
    
    
    public static void main(String[] args) {
        // Declaració de variables ---------------------------------------------
        Boolean sortir=false;        // Testimoni per sortir del menú general.
        Boolean sortir1n=false;     // Testimoni per sortir del menu secundari (operativa compte c.).
        int existeix;              // index del compte si existeix el compte -1 si no ex.
        double quantitat;         // Recull els ingressos i retirades de compte.
        Transaccio transac;      // Obj. Transaccio que recull les dades d'una transacció.
                
        
        
        
        int opcio;  //opció del menú general.
        
        
        
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        // Menú principal ------------------------------------------------------
        System.out.println("GESTIÓ BANCARIA  IT_ACADEMY fdlp");
        while(!sortir){
            System.out.println("1.- Crear Compte");
            System.out.println("2.- Eliminar Compte");
            System.out.println("3.- Dades del Compte");
            System.out.println("4.- Operacions amb  Compte");
            System.out.println("5.- Mostrar tots els comptes ");
            System.out.println("6.- Omplir Array amb dades de prova");
            System.out.println("0.- Sortir");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1:  //Crear compte corrent 
                    CompteCorrent nouCompte=demanarDades(); 
                    existeix=existeixCompteCorrent(comptes,nouCompte);
                    if(existeix!=-1){
                        System.out.println("El compte corrent ja existeix ");
                        System.out.println(nouCompte.toString());
                    }else{
                        comptes.add(nouCompte);
                        System.out.println("El compte corrent ha estat donat d'alta");
                        System.out.println(nouCompte.toString());
                    }
                    break;
                case 2: // Eliminar compte corrent
                    nouCompte=demanarDades(); 
                    existeix=existeixCompteCorrent(comptes,nouCompte);
                    if(existeix!=-1){
                        comptes.remove(existeix);
                        System.out.println(nouCompte.toString());
                        System.out.println("El compte corrent ha estat donat de baixa");                        
                    }else{
                        System.out.println("El compte corrent no existeix ");
                        System.out.println("Comptes associats a "+nouCompte.getNom()+", "+nouCompte.getCognoms());
                        cercarComptesClient(comptes,nouCompte);
                    }
                    break;
                case 3: //Dades del compte corrent 
                    nouCompte=demanarDades();
                    existeix=existeixCompteCorrent(comptes,nouCompte);
                    if(existeix!=-1){
                        System.out.println(nouCompte.toString());
                    }else{
                        cercarComptesClient(comptes,nouCompte);
                    }    
                    break;
                case 4:   // Operacions amb el compte corrent (ingrés, retirada, transaccions, consulta)
                    System.out.println("OPERATIVA AMB EL COMPTE CORRENT");
                    nouCompte=demanarDades();
                    existeix=existeixCompteCorrent(comptes,nouCompte);
                    
                    //Si el compte existeix accedim a l'operativa del compte
                    if(existeix!=-1){
                        // Mostrem informació del compte i del client.
                        System.out.println("Operativa amb el compte corrent número: "+nouCompte.getNumeroCompte());
                        System.out.println("Titular : "+nouCompte.getCognoms()+" ,"+nouCompte.getNom());
                        System.out.println();
                        
                        // Menú Secundari operativa sobre el compte corrent
                        
                        while(!sortir1n){
                            System.out.println("1.- Ingrés");
                            System.out.println("2.- Retirada");
                            System.out.println("3.- Transaccions del compte");
                            System.out.println("4.- Dades del compte");
                            System.out.println("0.- Sortir ");
                            opcio=lector.nextInt();
                        
                            switch(opcio){
                                case 1:  //Ingressar al compte corrent.
                                    //Genero la transacció ingrés
                                    transac = generarTransaccio("ingres", comptes.get(existeix).getSaldo());
                                    
                                    //Actualitzo el nou saldo
                                    System.out.println ("Transaccio :\n"+transac.getSaldo());
                                    System.out.println ("Compte :\n "+comptes.get(existeix).toString());
                                    comptes.get(existeix).setSaldo(transac.getSaldo());
                                    
                                    //Afegeixo la transacció al compte corrent (i)
                                    comptes.get(existeix).afegirTransaccio(transac);
                                    
                                    break;
                                case 2: // Retirada d'efectiu.
                                    //Genero la transacció retirar efectiu
                                    transac = generarTransaccio("retirada", comptes.get(existeix).getSaldo());
                                    
                                    //Actualitzo el nou saldo
                                    comptes.get(existeix).setSaldo(transac.getSaldo());
                                    
                                    //Afegeixo la transacció al compte corrent (i)
                                    comptes.get(existeix).afegirTransaccio(transac);
                                    
                                    break;                                    
                                case 3: //Transaccions del compte c. 
                                    System.out.println(comptes.get(existeix).TransaccionsToString());
                                    break;
                                case 4: // Dades del compte c.   
                                    System.out.println(comptes.get(existeix).toString());
                                    break;
                                case 0: // sortir.
                                    sortir1n=true;
                                    break;
                                default:// Opció incorrecta.
                                    System.out.println("Opció incorrecta, torna a triar [0..4]");
                            }        
                        }
                        
                    // si no existeix el compte, informem i mostrem tots els comptes associats.    
                    }else{
                        System.out.println("ATENCIÓ: El compte corrent introduit no existeix "); 
                        cercarComptesClient(comptes,nouCompte);    
                    }
                    
                    break;
                case 5:
                    mostrarComptes(comptes);              
                    break;
                case 6:
                    omplirArray();
                    break;                
                case 0:                    
                    sortir=true;
                    break;
                default:
                    System.out.println("Opció incorrecta, torna a triar [0..9]");               
                    
            }            
        }
    }// main
    
    
    /**
     * recollirImport
     * 
     * Retorna un valor double
     * 
     * @param   tipus           String          Tipus de la transacció.
     * @param   saldo           double          Saldo actual del compte corrent
     * @return  Transaccio      Transaccio      Objecte Transaccio.
     */
    public static Transaccio generarTransaccio(String tipus, double saldo){
        double valor=0;         // import de la transacció
        double nouSaldo=0;     // Saldo resultant després de la transacció        
        String datai;      // Data de la transacció (string)
        Date dataFinal=null; // Data de la transacció (obj Date)       
        Boolean iterar=true;//  Testimoni dels while
        
        Scanner lector=new Scanner(System.in); // Objecte Scanner per llegir de teclat.
        
        //Demano la data de la transacció        
        while(iterar){            
            System.out.print("Data [dd/mm/aaaa] : " );
            datai=lector.nextLine(); 

            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
            try{
                dataFinal=(Date) sdf.parse(datai);
                iterar=false;
            }catch(ParseException pe){
                System.out.println("El format de la data no és correcte [dd/mm/aaaa]");

            }
        }
                       
                
        // Demano l'import         
        iterar=true;
        while(iterar){
            System.out.print(tipus+" \n import  :" );
            valor=lector.nextDouble();
                       
            if(!isNaN(valor) && valor>0){
                iterar=false;
            }
        }        
        
        //Actualitzo el saldo del compte c.
        switch (tipus){
            case "ingres":
                nouSaldo=saldo+valor;                
                break;
            case "retirada":
                // si no hi ha prou saldo no realitzo la transacció.
                if(valor>saldo){
                    System.out.println("Impossible realitzar la transacció, no hi ha prou saldo comptable");
                    nouSaldo=saldo;
                }else{
                    nouSaldo=saldo-valor;
                }
                break;
            default:
                System.out.println("L'operació "+tipus+" no està implementada.");
        }
        
        //informo del nou saldo generat.
        System.out.println("Un cop realitzada l'operació, el saldo és de : "+nouSaldo);
        
        //Creo l'objecte Transaccio i el retorno amb les dades actualitzades.
        Transaccio novaTransaccio = new Transaccio();
        novaTransaccio.setData(dataFinal);
        novaTransaccio.setImporte(valor);
        novaTransaccio.setConcepte(tipus);
        novaTransaccio.setSaldo(nouSaldo);
        
        return novaTransaccio;
        
    }
    
    
    
    /**
     * cercarComptesClient
     * 
     * Cerca tots els comptes associats a un client (nom,cognoms)
     * 
     * @param comptesC  ArrayList de ComptesCorrents
     * @param compte    CompteCorrent
     * ************************************************************************************************ */
    public static void cercarComptesClient(ArrayList<CompteCorrent> comptesC, CompteCorrent compte){
        //Recollim variables de l'objecte compteCorrent a cercar.
        String nom = compte.getNom();
        String cognoms = compte.getCognoms();
        String compteC = compte.getNumeroCompte();
        int comptesTrobats=0;


        //Recorrem l'ArrayList per determinar si existeixen comptes associats al client.
        for(int i=0;i<comptesC.size();i++){
            if(comptesC.get(i).getNom().equals(nom) && comptesC.get(i).getCognoms().equals(cognoms)){
                comptesC.get(i).toString();
                comptesTrobats++;
            } 
        }    
        
        //Informem si el client no té cap compte corrent.
        if (comptesTrobats==0){
            System.out.println("ATENCIÓ: El Client "+nom+" ,"+cognoms+" No té cap compte corrent ");
        }
                

    }
   
    /**
     * mostrarComptes
     * 
     * Mostra tots el comptes que tenim en actiu.
     * @param comptes   ArrayList <CompteCorrent>
     */
    static void mostrarComptes(ArrayList <CompteCorrent> comptes){
        String compteStr,transaccionStr;
        for(int i=0;i<comptes.size();i++){
            System.out.println(comptes.get(i).toString());
            
        }
    }
    
    /**
     * demanarDades()
     * 
     * Demana les dades (nom,cognoms,num.Compte C.) i crea un obj. Compte Corrent
     * 
     * @return Obj CompteCorrent 
     */
    public static CompteCorrent demanarDades(){
        // Declaració de variables.
        String nom = "",cognoms = "",compteCorrent = "";   // Valors per crear el compte corrent.
        
        Boolean iterar=true;
        
        Scanner lector=new Scanner(System.in); // Objecte Scanner per llegir de teclat.
        
        // Demano el nom del client
        while(iterar){
            System.out.print("Nom : ");
            nom = lector.nextLine();
            
            if(nom.length() > 0){
                iterar=false;
            }
        }
        
        // Demano els cognoms del client
        iterar=true;
        while(iterar){
            System.out.print("Cognoms : ");
            cognoms = lector.nextLine();
            
            if(cognoms.length() > 0){
                iterar=false;
            }
        }
        
        // Demano el número del compte corrent (8 digits)
        iterar=true;
        while(iterar){
            System.out.print("Número de compte corrent [8dígits mínim]: ");
            compteCorrent=lector.nextLine();
            if(compteCorrent.length()>=8){
                iterar=false;
            }
        }
                
        // Creem l'objecte compte corrent i el retornem
        CompteCorrent nouCompte=new CompteCorrent(nom,cognoms,compteCorrent);
        return nouCompte;       
        
    }//demanarDades
    
    /**
     * existeixCompteCorrent
     * 
     * Determina si un compte corrent ja existeix.
     * 
     * @param   comptes           ArrayList d'objectes CompteCorrent
     * @param   compteCorrent     Objecte CompteCorrent
     * @return  existeix          int       -1 no existeix el compte corrent 
     */
    static int existeixCompteCorrent(ArrayList <CompteCorrent> comptes, CompteCorrent compteCorrent){
        //Declaració de variables.
        int existeix = -1;  //Testimoni de si existeix o no el compte passat.
        
        String nom = compteCorrent.getNom();
        String cognoms = compteCorrent.getCognoms();
        String compteC = compteCorrent.getNumeroCompte();
        
        //Recorrem l'ArrayList per determinar si el compte ja existeix.
        for(int i=0;i<comptes.size();i++){
            // Si número de compte, nom i cognoms coincideixen amb algun compte de l'ArrayList
            if (comptes.get(i).getNumeroCompte().equals(compteC)){
                if(comptes.get(i).getNom().equals(nom) && comptes.get(i).getCognoms().equals(cognoms)){
                    existeix = i;
                }                
            }
        }        
        return existeix;
    }//existeixCompteCorrent
    
    /**
     * omplirArray amb dades inicials per fer proves.
     * 
     * Afegeix 10 comptes corrents i les seves transaccions inicials.  * 
     * *****************************************************************************************************/
    public static void omplirArray(){
        Calendar cal;
        cal = new GregorianCalendar(); //Object calendar per assignar una data.
        Date data;            //data de la transacció
        Transaccio transac;  //Obj Transacció per afegir a l'array de transaccions del compte c.
        
        // TR1  ----------->
        CompteCorrent nouCompte =new CompteCorrent("Joan","Mainat","11111111");
        cal.set(2021,01,12);
        data = cal.getTime();       
        transac = new Transaccio (data,"ingres",20.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",120.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR2   ----------->
        nouCompte =new CompteCorrent("joan","Mainat","22222222");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",150.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR3   ----------->
        nouCompte =new CompteCorrent("Pere","Calders","33333333");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",35.58,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR4   ----------->
        nouCompte =new CompteCorrent("Rosa","Parks","44444444");        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",70.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",12.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR5   ----------->
        nouCompte =new CompteCorrent("Tania","Garriga","55555555");
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",150.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",20.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        comptes.add(nouCompte);
        
        // TR6   ----------->
        nouCompte =new CompteCorrent("Tania","Garriga","66666666");
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR7   ----------->
        nouCompte =new CompteCorrent("Marc","Salmeron","77777777");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",12.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR8   ----------->
        nouCompte =new CompteCorrent("Laia","Pinyol","88888888");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",70.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",12.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR9   ----------->
        nouCompte =new CompteCorrent("Laia","Pinyol","99999999");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",70.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",12.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        comptes.add(nouCompte);
        
        // TR10   ----------->
        nouCompte =new CompteCorrent("Nuria","Permach","00000000");
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",170.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,03,19);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"ingres",150.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        
        cal.set(2021,02,10);
        data = (Date) cal.getTime();       
        transac = new Transaccio (data,"retirada",120.50,nouCompte.getSaldo());
        nouCompte.afegirTransaccio(transac);
        comptes.add(nouCompte);
        
        // TR11   ----------->
        nouCompte =new CompteCorrent("juanjo","campos","12345678");
        comptes.add(nouCompte);
        
        System.out.println("Les dades de prova han estat carregades correctament ......");
    }//omplirArray
    
       
    }//class M7exercici2
    

