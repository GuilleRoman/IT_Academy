package N3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fase_1 {
	
	public static Scanner lector = new Scanner(System.in);
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
		Boolean iterar=true;
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 2 \n");
		
			
		omplirPlatsPreus();						 // Creació de plats i els seus preus corresponents implementats en un HashMap.	
		omplirArrays();						    // Omplim els arrays plats i preus amb les dades del HashMap
		mostrarCarta();		   				   // Mostrem la carta per cónsola.
		
		System.out.println("\nSelecciona els plats de la carta : \n");
		// Selecciono els plats de la carta.
		do {
			try {
				seleccionarPlats();     			  
				iterar=false;
			}catch(Exception e) {
				System.out.println(e.getMessage());		
			}
		}while(iterar);
		
		
		System.out.println("\nResum de la comanda :");
		totalComanda=(mostrarComanda());	// Mostra la comanda un cop finalitzada la tria de plats
		
		System.out.println();
		Fase_1.pagament(totalComanda);	   // Indiquem amb quins bitllets s'ha de pagar la comanda. 
		
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
			if(i>=0 & i<plats.length) {
				System.out.println(plats[i]+"  [ "+preus[i]+"eur ]");
				totalMenu+=preus[i];
			}else {
				System.out.println("El plat número "+i+" no existeix a la carta" );
			}
		}
		
		System.out.println("Total a pagar : "+totalMenu+" eur.");
		return totalMenu;
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
				
		while(iterar) {
			plat=demanarSencer("Selecciona el número de plat : ");    //demanem el número de plat
			
			try {
				if(plat<plats.length) {
					comanda.add(plat);				
					
					char valorContinua = continuar("Vols demanar més plats (S/N) :");
					if(valorContinua=='N') {
						iterar=false;
					}				
					
				}else {
					
					throw new platErroni("Plat inexistent al menú");				
				}
			}catch(platErroni pe) {
				System.out.println(pe.getMessage());
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
		Boolean iterar=true;
		char continuar='N';
		
		while(iterar) {
			try {
				System.out.print(missatge);
				continuar=Character.toUpperCase(lector.next().charAt(0));
						
				if(continuar=='S' || continuar=='N') { 
			      iterar=false;
				}else {
				  throw new TipusErroni("Opció incorrecta");
				}
			}catch(TipusErroni te) {
				System.out.print(te.getMessage()+"  ");
			}
		}
		
		return continuar;
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
	 * demanarSencer
	 * 
	 * Recull per teclat un valor de tipus sencer, el qual
	 * retorna com a resultat de la funció.
	 * 	 
	 * @return	valor	int		
	 */
	public static int demanarSencer(String missatge) {
		int valor = 0;		
		Boolean iterar = true;
		
		while (iterar) {
			try {
				System.out.print(missatge);
				valor = lector.nextInt();
				iterar=false;
			} catch (Exception ex) {
				System.out.print("Valor incorrecte, torna a introduir-lo : ");
				lector.next();
			}
		}
		
		return valor;		
	}
	
	/**
	 * pagament 
	 * 
	 * Cerca la forma més eficient de pagament
	 * de la quantitat passada per paràmetre.
	 * 
	 * 
	 * @param valor
	 */
	public static void pagament(int valor) {
		int euro, cinc, deu, vint, cinquanta, cent, dosCents, cincCents, resto=0;
		
		cincCents= Math.abs(valor/500);
		resto=valor-(cincCents*500);
		
		dosCents= Math.abs(resto/200);
		resto=resto-(dosCents*200);
		
		cent= Math.abs(resto/100);
		resto=resto-(cent*100);
		
		cinquanta= Math.abs(resto/50);
		resto=resto-(cinquanta*50);
		
		vint= Math.abs(resto/20);
		resto=resto-(vint*20);
		
		deu = Math.abs(resto/10);
		resto=resto-(deu*10);
		
		cinc= Math.abs(resto/5);
		resto=resto-(cinc*5);
		
		euro= Math.abs(resto/1);
		resto=resto-(euro*1);
		
		System.out.println("Forma de pagament: ");
		if (cincCents>0) { System.out.println(" -"+cincCents+" bitllets de 500 euros"); }
		if (dosCents>0) { System.out.println(" -"+dosCents+" bitllets de 200 euros"); }
		if (cent>0) { System.out.println(" -"+cent+" bitllets de 100 euros"); }
		if (cinquanta>0) { System.out.println(" -"+cinquanta+" bitllets de 50 euros"); }
		if (vint>0) { System.out.println(" -"+vint+" bitllets de 20 euros"); }
		if (deu>0) { System.out.println(" -"+deu+" bitllets de 10 euros"); }
		if (cinc>0) { System.out.println(" -"+cinc+" bitllets de 5 euros"); }
		if (euro>0) { System.out.println(" -"+euro+" monedes de 1 euro"); }
		
	}	
}
