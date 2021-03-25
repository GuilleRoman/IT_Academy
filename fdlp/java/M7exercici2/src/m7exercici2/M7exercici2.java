/*
 * IT ACADEMY
 * Fonaments de la programació  -POO-
 * Juan José Campos Caballero.
 */
package m7exercici2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juanj
 */
public class M7exercici2 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Declaració de variables ---------------------------------------------
        Boolean sortir=false;       // Testimoni per sortir del menú general.
        Boolean existeix=false;    // Testimini de si existeix el compte.
        
        // ArrayList amb tots els comptes corrents 
        ArrayList<CompteCorrent> comptes = new ArrayList();
        
        
        int opcio;  //opció del menú general.
        
        
        
        //objecte Scanner per llegir del teclat.        
        Scanner lector= new Scanner(System.in);
        
        // Menú principal ------------------------------------------------------
        System.out.println("GESTIÓ BANCARIA  IT_ACADEMY fdlp");
        while(!sortir){
            System.out.println("1.- Crear Compte");
            System.out.println("2.- Eliminar Compte");
            System.out.println("3.- Dades del Compte");
            System.out.println("4.- Transaccions del Compte");
            System.out.println("5.- Ingressar al compte");
            System.out.println("6.- Retirar saldo del compte");
            System.out.println("7.- Consulta del saldo");
            System.out.println("8.- Mostrar tots els comptes ");
            System.out.println("9.- Sortir");
            System.out.println("");
            System.out.print("Tria l'opció :");
            opcio=lector.nextInt();
            
            switch(opcio){
                case 1:
                    CompteCorrent nouCompte=demanarDades(); 
                    existeix=existeixCompteCorrent(comptes,nouCompte);
                    if(existeix){
                        System.out.println("El compte corrent ja existeix ");
                        System.out.println(nouCompte.toString());
                    }else{
                        comptes.add(nouCompte);
                        System.out.println("El compte corrent ha estat donat d'alta");
                        System.out.println(nouCompte.toString());
                    }
                    break;
                case 2:
                    
                    break;
                case 3:
                   
                    break;
                case 4:
                                     
                    break;
                case 5:
                                  
                    break;
                case 6:
                    
                    break;
                case 7:
                   
                    break; 
                case 8:
                    mostrarComptes(comptes);
                    break;  
                case 9:                    
                    sortir=true;
                    break;
                default:
                    System.out.println("Opció incorrecta, torna a triar [1..4]");               
                    
            }            
        }
    }// main
    
    
    static void mostrarComptes(ArrayList <CompteCorrent> comptes){
        for(int i=0;i<comptes.size();i++){
            comptes.get(i).toString();
        }
    }
    
    /**
     * demanarDades()
     * 
     * Demana les dades (nom,cognoms,num.Compte C.) i crea un obj. Compte Corrent
     * 
     * @return Obj CompteCorrent 
     */
    static CompteCorrent demanarDades(){
        // Declaració de variables.
        String nom = "",cognoms = "",compteCorrent = "";   // Valors per crear el compte corrent.
        
        Boolean iterar=true;
        
        Scanner lector=new Scanner(System.in); // Objecte Scanner per llegir de teclat.
        
        // Demano el nom del client
        while(iterar){
            
            nom = lector.nextLine();
            
            if(nom.length() > 0){
                iterar=false;
            }
        }
        
        // Demano els cognoms del client
        iterar=true;
        while(iterar){
            
            cognoms = lector.nextLine();
            
            if(cognoms.length() > 0){
                iterar=false;
            }
        }
        
        // Demano el número del compte corrent (8 digits)
        iterar=true;
        while(iterar){
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
     * 
     * @param   comptes           ArrayList d'objectes CompteCorrent
     * @param   compteCorrent     Objecte CompteCorrent
     * @return  existeix    Boolean     true existeix el compte corrent 
     */
    static Boolean existeixCompteCorrent(ArrayList <CompteCorrent> comptes, CompteCorrent compteCorrent){
        //Declaració de variables.
        Boolean existeix = false;  //Testimoni de si existeix o no el compte passat.
        
        String nom = compteCorrent.getNom();
        String cognoms = compteCorrent.getCognoms();
        String compteC = compteCorrent.getNumeroCompte();
        
        //Recorrem l'ArrayList per determinar si el compte ja existeix.
        for(int i=0;i<comptes.size();i++){
            // Si número de compte, nom i cognoms coincideixen amb algun compte de l'ArrayList
            if (comptes.get(i).getNumeroCompte().equals(compteC)){
                if(comptes.get(i).getNom().equals(nom) && comptes.get(i).getCognoms().equals(cognoms)){
                    existeix=true;
                }                
            }
        }        
        return existeix;
    }//existeixCompteCorrent
    
    
    
       
    }//class M7exercici2
    

