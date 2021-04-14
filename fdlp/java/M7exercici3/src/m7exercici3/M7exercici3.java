/*
 * IT ACADEMY  .
 * Fonaments de la programació -POO-
 * Juan José Campos Caballero.
 */
package m7exercici3;

import static java.lang.Double.isNaN;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author juanj
 */
public class M7exercici3 {
    
    // ArrayList amb tots els clients 
    public static ArrayList<Client> clients = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaració de variables ---------------------------------------------
        Boolean sortir=false;        // Testimoni per sortir del menú general.
        Boolean sortir1n=false;     // Testimoni per sortir del menu secundari (operativa compte c.).
        int existeix;              // index del compte si existeix el client -1 si no ex.
        int opcio;                //opció del menú general.
        int compteTrobat;        // Si el compte pertany al client index, else -1
        Client nouClient;       // Obj Client 
        CompteCorrent compte;  // Obj CompteCorrent 
        String compteStr;     // String on recollim el compte corrent llegit per teclat    
        Transaccio transac;  // var. on emma. les noves transaccions
        
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        // Menú principal ------------------------------------------------------
        System.out.println("GESTIÓ BANCARIA  IT_ACADEMY fdlp");
        while(!sortir){
            System.out.println("1.- Crear Client");
            System.out.println("2.- Eliminar Client");
            System.out.println("3.- Crear compte corrent");
            System.out.println("4.- Operacions amb els comptes");
            System.out.println("5.- Mostrar tots els clients");
            System.out.println("6.- Carregar les dades de prova ");
            System.out.println("7.- Mostrar dades de prova");
            System.out.println("0.- Sortir");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1:  //Crear client
                    nouClient=demanarDades();                    
                    existeix=existeixClient(nouClient);
                    if(existeix!=-1){
                        System.out.println("El client  ja existeix ");
                        System.out.println(nouClient.toString());
                    }else{
                        clients.add(nouClient);
                        System.out.println("El nou client ha estat donat d'alta");
                        System.out.println(nouClient.toString());
                    }
                    break;
                case 2: // Eliminar client
                    nouClient=demanarDades(); 
                    existeix=existeixClient(nouClient);
                    if(existeix!=-1){
                        clients.remove(existeix);
                        System.out.println(nouClient.toString());
                        System.out.println("El Client ha estat esborrat");                        
                    }else{
                        System.out.println("El client no existeix  i no el podem esborrar ");                        
                    }
                    break; 
                case 3:   //Crear un nou compte corrent 
                    //Demanem el client que ha de crear el compte
                    nouClient=demanarDades();
                    existeix=existeixClient(nouClient);
                    
                    // Si el client existeix, accedim a crear el compte corrent
                    if(existeix!=-1){
                        compte=crearCompte();
                        clients.get(existeix).getComptes().add(compte);
                    }else{ // El client no existeix i per tant no pot obrir cap compte corrent.
                        System.out.println("El client introduit no existeix"); 
                    }
                    break; 
                    
                case 4:   // Operacions amb el compte corrent (ingrés, retirada, transaccions, consulta)
                    sortir1n=false;
                    System.out.println("OPERATIVA AMB EL COMPTE CORRENT");
                    //Identifiquem el client actiu i determinem si existeix el client.
                    nouClient=demanarDades();
                    existeix=existeixClient(nouClient);
                    
                    //Si el client existeix, determinem el compte amb el que vol treballar i 
                    // accedim a l'operativa del compte
                    if(existeix!=-1){
                        
                        if(clients.get(existeix).getComptes().size()>0){
                            
                            //Mostrem els comptes associats al client
                            System.out.println("---------- Comptes associats al client ----------");
                            clients.get(existeix).mostrarComptesCorrents();
                            
                        //Demanem amb quin compte vol treballar
                        compteStr=demanarCompteCorrent();

                        //Comprovem que el compte pertany al client.
                        compteTrobat = clients.get(existeix).existeixElCompte(compteStr);
                       //Si existeix entrem a operativa compte corrent, sinò missatge d'error.
                        if(compteTrobat!=-1){

                            // Mostrem informació del compte i del client i operativa.
                            System.out.println("Operativa amb el compte corrent número: "+clients.get(existeix).getComptes().get(compteTrobat).getNumeroCompte());
                            System.out.println("Titular : "+clients.get(existeix).getNom()+" ,"+clients.get(existeix).getCognoms());
                            System.out.println();

                            // Menú Secundari operativa sobre el compte corrent

                            while(!sortir1n){
                                System.out.println("1.- Crear un nou compte corrent");
                                System.out.println("2.- Ingrés");
                                System.out.println("3.- Retirada");
                                System.out.println("4.- Transaccions del compte");
                                System.out.println("5.- Dades del compte");
                                System.out.println("0.- Sortir ");
                                opcio=lector.nextInt();

                                switch(opcio){
                                    case 1:
                                        //Demanem el client que ha de crear el compte
                                        nouClient=demanarDades();
                                        existeix=existeixClient(nouClient);

                                        // Si el client existeix, accedim a crear el compte corrent
                                        if(existeix!=-1){
                                            compte=crearCompte();
                                            clients.get(existeix).getComptes().add(compte);
                                        }else{ // El client no existeix i per tant no pot obrir cap compte corrent.
                                            System.out.println("El client introduit no existeix"); 
                                        }
                                        break;
                                    case 2:  //Ingressar al compte corrent.
                                        //Genero la transacció ingrés
                                        transac = generarTransaccio("ingres", clients.get(existeix).getComptes().get(compteTrobat).getSaldo());

                                        //Actualitzo el nou saldo
                                        clients.get(existeix).getComptes().get(compteTrobat).setSaldo(transac.getSaldo());
                                        
                                        //Afegeixo la transacció al compte corrent (i)
                                        clients.get(existeix).getComptes().get(compteTrobat).afegirTransaccio(transac);                                       

                                        break;
                                    case 3: // Retirada d'efectiu.
                                        //Genero la transacció retirar efectiu
                                        transac = generarTransaccio("retirada", clients.get(existeix).getComptes().get(compteTrobat).getSaldo());

                                        //Actualitzo el nou saldo
                                        clients.get(existeix).getComptes().get(compteTrobat).setSaldo(transac.getSaldo());
                                        
                                        //Afegeixo la transacció al compte corrent (i)
                                        clients.get(existeix).getComptes().get(compteTrobat).afegirTransaccio(transac);                                        

                                        break;                                    
                                    case 4: //Transaccions del compte c.
                                        System.out.println("---------- Transaccions del compte ----------");
                                        System.out.println(clients.get(existeix).getComptes().get(compteTrobat).TransaccionsToString());
                                        break;
                                    case 5: // Dades del compte c.   
                                        System.out.println("---------- Informació del compte ----------");
                                        System.out.println(clients.get(existeix).toString());
                                        System.out.println(clients.get(existeix).getComptes().get(compteTrobat).toString());
                                        break;
                                    case 0: // sortir.
                                        sortir1n=true;
                                        break;
                                    default:// Opció incorrecta.
                                        System.out.println("Opció incorrecta, torna a triar [0..5]");
                                }        
                            }
                        
                        } else {
                            System.out.println("ATENCIÓ: El compte corrent introduit no existeix ");
                        }  
                        
                    }else{
                        System.out.println("ATENCIÓ: El client no té cap compte corrent associat");
                         System.out.println("Cal crear un compte corrent abans  ");
                    }   
                        
                    // si no existeix el client, informem .    
                    }else{
                        System.out.println("ATENCIÓ: El client introduit no existeix ");
                        mostrarDades(0);
                    }
                    
                    break;
                case 5:
                    mostrarDades(0);    //Mostrar tots els clients        
                    break;
                case 6:
                    carregarDadesInicials();  // Carrega dades de prova amb clients,comptes i transaccions
                    break; 
                case 7:
                    mostrarDades(2);  //Mostra clients,comptes i transferencies associades.
                    break;                
                case 0:                    
                    sortir=true;  //Sortir de l'aplicació.
                    break;
                default:
                    System.out.println("Opció incorrecta, torna a triar [0..9]");               
             
            }            
        }
        
        
        
        
        
        
    }// public void main *******************************************************************************************************
    
    /**
     * creaCompte
     * 
     * Crea un compte nou amb el número introduit i amb un saldo inicial de 50 eur.
     * 
     * @return  nouCompte   Compte  
     */
    public static CompteCorrent crearCompte(){
        // Declaració de variables.
        String compteCorrent = "";   // Valors per crear el compte corrent.
        
        Boolean iterar=true;
        
        Scanner lector=new Scanner(System.in); // Objecte Scanner per llegir de teclat.
        
        
        // Demano el número del compte corrent (8 digits)
        iterar=true;
        while(iterar){
            System.out.print("Número de compte corrent [8dígits mínim]: ");
            compteCorrent=lector.nextLine();
            
            // filtro longitud mínima i si no existeix.
            if(compteCorrent.length()>=8) {               
                if(existeixElCompte(compteCorrent)==0){
                    
                    iterar=false;
                }else{
                     System.out.println("El compte corrent ja existeix, introdueixi un altre.");
                }                         
            }else{
                 System.out.println("Longitud del compte inferior a 8 dígits, torni a introduir un altre.");
            }            
        }
                
        // Creem l'objecte compte corrent i el retornem
        CompteCorrent nouCompte=new CompteCorrent(compteCorrent);
        return nouCompte;       
        
    }//demanarDades
    
     /**
      * existeixElCompte
      * 
      * Determina si el compte passat existeix 
      * 
      * @param      compteCreat     String
      * 
      * @return     integer         0   no existeix cap compte amb aquest num.
      *                             1   existeix el compte 
      */
     public static int existeixElCompte(String compteCreat){
         //Recorrem l'array de clients i cerquem coincidències amb el compte passat via param.
         for(int i=0;i<clients.size();i++){  //Clients
             for(int j=0;j<clients.get(i).getComptes().size();j++){ //comptes
                 if(clients.get(i).getComptes().get(j).getNumeroCompte().equals(compteCreat)){
                     return 1;
                 }
             }
                 
         }
         return 0;
     }//existeix el compte
    
    
    
    
    /**
     * demanarCompteCorrent
     * 
     * Recull del teclat un compte corrent de com a mínim 8 dígits
     * 
     * @return compteCorrent    String 
     */
    public static String demanarCompteCorrent(){
         // Demano el número del compte corrent (8 digits)
        Boolean iterar=true;
        String compteCorrent="";
        
        Scanner lector=new Scanner(System.in); // Objecte Scanner per llegir de teclat.
        
        while(iterar){
            System.out.print("Número de compte corrent a operar [8dígits mínim]: ");
            compteCorrent=lector.nextLine();
            if(compteCorrent.length()>=8){
                iterar=false;
            }
        }
        
        return compteCorrent;        
    }
    
    
    /**
     * demanarDades()
     * 
     * Demana el nom i els cognoms i crea un objecte Client que retorna.
     * 
     * @return  nouClient   Client  Retorna un objecte client creat 
     */
    public static Client demanarDades(){
        // Declaració de variables.
        String nom = "",cognoms = "";   // Valors per crear el client.
        
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
                
        // Creem l'objecte compte corrent i el retornem
        Client nouClient=new Client(nom,cognoms);
        return nouClient;       
        
    }//demanarDades
    
    
    
    /**
     * existeixClient
     * 
     * Retorna l'index que ocupa el client a l'ArrayList, -1 si no existeix.
     * @param   client
     * @return  existeix    int     -1 si no existeix, n si existeix.
     * *************************************************************************/
    public static int existeixClient(Client client){
        int existeix=-1;
        
        for(int i=0;i<clients.size();i++){
            if(clients.get(i).nom.equals(client.getNom()) && clients.get(i).getCognoms().equals(client.getCognoms())){
                existeix=i;
            }
        }
        return existeix;
    }//existeixClient
    
    
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
     * carregarDadesInicials
     * 
     * Carrega les dades inicials de l'aplicació amb dades de prova
     */
    public static void carregarDadesInicials(){
        Client nouClient;
        CompteCorrent nouCompte;
        Calendar cal;
        cal = new GregorianCalendar(); //Object calendar per assignar una data.
        Date data;            //data de la transacció
        Transaccio transac;  //Obj Transacció per afegir a l'array de transaccions del compte c.
        
        
        //Client 1  -----------------------------------
            // Creo un client
            nouClient = new Client("juanjo","campos");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("12345678");
            
            //Afegeixo transaccions
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

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            clients.add(nouClient);
        
        
        //Client 2 -----------------------------------
            nouClient = new Client("Joan","Mainat");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("11111111");

            //Afegeixo transaccions
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

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);
        
        //Client 3 -----------------------------------
            nouClient = new Client("Pere","Calders");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("22222222");

            //Afegeixo transaccions
            cal.set(2021,02,10);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"ingres",35.58,nouCompte.getSaldo());
            nouCompte.afegirTransaccio(transac);

            cal.set(2021,02,10);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
            nouCompte.afegirTransaccio(transac);

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
        
            clients.add(nouClient);
        
        //Client 4 -----------------------------------
            nouClient = new Client("Rosa","Parks");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("33333333");

            //Afegeixo transaccions
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
            
            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);
               
        //Client 5 -----------------------------------
            nouClient = new Client("Tania","Garriga");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("44444444");

            //Afegeixo transaccions
            cal.set(2021,03,19);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"ingres",150.50,nouCompte.getSaldo());
            nouCompte.afegirTransaccio(transac);

            cal.set(2021,02,10);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"retirada",20.50,nouCompte.getSaldo());
            nouCompte.afegirTransaccio(transac);

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);
        
        //Client 6 -----------------------------------
            nouClient = new Client("Marc","Salmeron");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("55555555");

            //Afegeixo transaccions
            cal.set(2021,03,19);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"ingres",50.50,nouCompte.getSaldo());

            nouCompte.afegirTransaccio(transac);

            cal.set(2021,02,10);
            data = (Date) cal.getTime();       
            transac = new Transaccio (data,"retirada",10.50,nouCompte.getSaldo());
            nouCompte.afegirTransaccio(transac);

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);
            
        //Client 7 -----------------------------------
            nouClient = new Client("Laia","Pinyol");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("66666666");

            //Afegeixo transaccions
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

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);

        //Client 8 -----------------------------------
            nouClient = new Client("Nuria","Permach");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("77777777");

            //Afegeixo transaccions
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

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);

        //Client 9 -----------------------------------
            nouClient = new Client("Carme","Oliveres");

            //Creo un compte corrent
            nouCompte = new CompteCorrent("88888888");

            //Afegeixo transaccions
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

            //Afegeixo el compte corrent al client
            nouClient.afegirCompteCorrent(nouCompte);
            
            clients.add(nouClient);
            
            System.out.println("Les dades de prova han estat carregades.");
        
    }
    
    
    /**
     * 
     * @param nivell    int     n[1,2]  mostra els clients.
     *                          1       mostra els clients i els comptes.
     *                          2       mostra els clients, els comptes i tes transaccions.
     */
    public static void mostrarDades(int nivell){
         for(int i=0;i<clients.size();i++){
            System.out.print(clients.get(i).toString());  //Mostrar el client
            if(nivell==1 || nivell==2){
                for(int j=0;j<clients.get(i).getComptes().size();j++){
                    System.out.print(clients.get(i).getComptes().get(j).toString());   // Mostrar els comptes del client
                    if(nivell==2){
                        for(int k=0;k<clients.get(i).getComptes().get(j).getTransaccions().size();k++){
                            System.out.print(clients.get(i).getComptes().get(j).getTransaccions().get(k).toString()); //Mostra les transaccions del compte.                        
                        }
                    }
                }
            }    
         }
    }           
    
    
    
    
    /**
     * mostrarDadesInicials
     * 
     * Mostra les dades completes dels clients,comptes i transaccions 
     */
    public static void mostrarDadesInicials(){
        for(int i=0;i<clients.size();i++){
            System.out.print(clients.get(i).toString());  //Mostrar el client            
                for(int j=0;j<clients.get(i).getComptes().size();j++){
                    System.out.print(clients.get(i).getComptes().get(j).toString());   // Mostrar els comptes del client
                for(int k=0;k<clients.get(i).getComptes().get(j).getTransaccions().size();k++){
                    System.out.print(clients.get(i).getComptes().get(j).getTransaccions().get(k).toString()); //Mostra les transaccions del compte.
                }        
            }            
        }
    }
    
    
}
