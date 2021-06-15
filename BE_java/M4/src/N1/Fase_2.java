package N1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/** 
 * IT Academy BE Java
 * @author juanj
 *Exercici M4 Fase 2
 */


public class Fase_2 {
	private static String plats[] = new String [15];
	private static int preus[] = new int[15];
	private static HashMap<String, Integer> preuPlat = new HashMap<String, Integer>();
	private static ArrayList<Integer> comanda = new ArrayList<Integer>();
	
	/**
	 * main 
	 * 	 
	 * @param args
	 */
	public static void main(String[] args) {
		int totalComanda=0;
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 2 \n");
		
			
		omplirPlatsPreus();						 // Creació de plats i els seus preus corresponents implementats en un HashMap.	
		omplirArrays();						    // Omplim els arrays plats i preus amb les dades del HashMap
		mostrarCarta();		   				   // Mostrem la carta per cónsola.
		seleccionarPlats();     			  // Selecciona els plats de la carta.
		System.out.println("\nResum de la comanda :");
		totalComanda=(mostrarComanda());	 // Mostra la comanda un cop finalitzada la tria de plats
		System.out.println();
		Fase_1.pagament(totalComanda);			// Indiquem amb quins bitllets s'ha de pagar la comanda. 
		
	}
	
	/**
	 * mostrarComanda
	 * 
	 * 
	 * @return
	 */
	public static int mostrarComanda() {
		int totalMenu=0;
		
		Collections.sort(comanda);
		for(int i : comanda) {			
				System.out.println(plats[i]+"  [ "+preus[i]+"eur ]");
				totalMenu+=preus[i];			
		}
		
		System.out.println("Total a pagar : "+totalMenu+" eur.");
		return totalMenu;
	}
	
	
	
	
	/**
	 * omplirPlatsPreus()
	 * 
	 * Omple el HashMap amb els plats com a clau i
	 * amb el preu com a valor.
	 * 
	 * 
	 */
	public static void omplirPlatsPreus() {
		
		preuPlat.put("Garota a la crema", 28);
		preuPlat.put("Tartar vegetal", 18);
		preuPlat.put("Costellam de garrinet, amb ceba tendra", 21);
		preuPlat.put("Vieira a la planxa, puré de coliflor", 6);
		preuPlat.put("Ventresca de bonitol en oli", 14);
		preuPlat.put("Croquetes de carn d'olla", 11);
		preuPlat.put("Bunyols de bacallà", 12);
		preuPlat.put("Foie a la graella amb fruits del bosc", 16);
		preuPlat.put("Amanida tèbia de verdures", 18);
		preuPlat.put("Ou Mollet amb múrgules", 25);
		preuPlat.put("Gelats i sorbets artesans", 10);
		preuPlat.put("Coulant d'avellana", 12);
		preuPlat.put("Mil fulls de nata i maduixetes del bosc", 12);
		preuPlat.put("Fruita del temps", 8);
		preuPlat.put("Amanida de fruites de temporada", 11);
		
	}
	
	
	/**
	 * omplirArrays
	 * 
	 * Omple els arrays plats[] i preus amb les dades
	 * que es troben al HashMap preuPlat.
	 */
	public static void omplirArrays() {
		int contador=0;
		
		for(Map.Entry<String, Integer> entrada : preuPlat.entrySet()) {
			plats[contador] = entrada.getKey();
			preus[contador] = entrada.getValue();
			contador++;
		}
	}
	
	
	/**
	 * mostrarCarta
	 * 
	 * Mostra la carta i els preus dels
	 * arrays plats i preus.
	 * 
	 */
	public static void mostrarCarta() {
		
		System.out.println("MENÚ MILLORS CREACIONS \n");
		
		for(int i=0; i<plats.length;i++) {
			System.out.println(" "+i+" -"+plats[i]+"  ["+preus[i]+" eur.]");
			
		}		
	}
	
	
	/**
	 * Seleccionar plats
	 * 
	 * Selecciona els plats a demanar a cuina
	 */
	public static void seleccionarPlats() {
		Boolean iterar=true;
		int plat=0;
		int parcial=0;
		
		System.out.println("\nSelecciona els plats de la carta : \n");
		
		while(iterar) {
			System.out.print("- Número de plat : ");
			plat=Fase_1.demanarSencer();    //demanem el número de plat
			System.out.println();
			
			if(plat<plats.length) {
				comanda.add(plat);
				
				parcial+=preus[plat];
				System.out.println("Cost actual de la comanda: "+parcial+" eur.n");
				
				if(continuar("Vols demanar més plats (S/N) :")=='N') {
					iterar=false;
				}
			}else {
				System.out.println("Opció incorrecta: tria de nou el número de plat "+"[ "+"0"+".."+(plats.length-1)+" ]");
			}		
		}		
	}
	
	
	/**
	 * continuar
	 * 
	 * Recull una resposta per teclat de S o N
	 * 
	 * 
	 * @param missatge
	 * @return	char	continuar	'S', 'N'
	 */
	public static char continuar(String missatge) {
		char continuar='N';
		
		do {
			
			System.out.print(missatge);
			continuar=Character.toUpperCase(Fase_1.lector.next().charAt(0));
		}while(continuar!='S' & continuar!='N');
		
		return continuar;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
