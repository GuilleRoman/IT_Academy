package N1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/** 
 * IT Academy BE Java
 * @author juanj
 *Exercici M4 Fase 1
 */

public class Fase_1 {

	private static String plats[] = new String [15];
	private static int preus[] = new int[15];
	private static ArrayList<Integer> comanda = new ArrayList<Integer>();
	public static Scanner lector = new Scanner(System.in);
		
	/**
	 * main 
	 * 	 
	 * @param args
	 */
	public static void main(String[] args) {
		int totalComanda=0;		//import total de la comanda feta.
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 3 Fase 1 \n");
		
			
		omplirPlatsPreus();						// Creació de plats i els seus preus corresponents.	
		mostrarCarta();		   				   // Mostrem la carta per cónsola.
		seleccionarPlats();   				  // Selecciona els plats de la carta.
		totalComanda=(mostrarComanda());	 // Mostra la comanda un cop finalitzada la tria de plats
		pagament(totalComanda);				// Indiquem amb quins bitllets s'ha de pagar la comanda. 
		

	}
	
	
	/**
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
	
	
	/**
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
	 * 
	 */
	public static void seleccionarPlats() {
		Boolean iterar=true;
		int plat=0;
		
		System.out.println("\nSelecciona els plats de la carta : \n");
		
		while(iterar) {
			System.out.print("- Número de plat : ");
			plat=demanarSencer();    //demanem el número de plat
			System.out.println();
			
			if(plat==plats.length) {
				iterar=false;
			}else if(plat<plats.length) {
				comanda.add(plat);
			}else {
				System.out.println("Opció incorrecta: tria de nou el número de plat "+"[ "+"0"+".."+plats.length+" ]");
			}		
		}		
	}
	
	
	/**
	 * demanarSencer
	 * 
	 * Recull per teclat un valor de tipus sencer, el qual
	 * retorna com a resultat de la funció.
	 * 	 
	 * @return	valor	int		
	 */
	public static int demanarSencer() {
		int valor = 0;		
		Boolean iterar = true;
		
		while (iterar) {
			try {
				valor = lector.nextInt();
				iterar=false;
			} catch (InputMismatchException ex) {
				System.out.print("Valor incorrecte, torna a introduir-lo : ");
				//lector.next();
			}
		}
		
		return valor;		
	}
	
	
	/**
	 * 
	 */
	public static void mostrarCarta() {
		
		System.out.println("MENÚ MILLORS CREACIONS \n");
		
		for(int i=0; i<plats.length;i++) {
			System.out.println(" "+i+" -"+plats[i]+"  ["+preus[i]+" eur.]");
			
		}
		System.out.println();
		System.out.println(" "+plats.length+" -  per finalitzar la comanda.");
	}
		
	
	/**
	 * 
	 */
	public static void omplirPlatsPreus() {
		plats[0] ="Garota a la crema";
		preus[0] =28;
		
		plats[1] ="Tartar vegetal";
		preus[1] =18;
		
		plats[2] ="Costellam de garrinet, amb ceba tendra";
		preus[2] =21;
		
		plats[3] ="Vieira a la planxa, puré de coliflor";
		preus[3] =6;
		
		plats[4] ="Ventresca de bonitol en oli";
		preus[4] =14;
		
		plats[5] ="Croquetes de carn d'olla";
		preus[5] =11;
		
		plats[6] ="Bunyols de bacallà";
		preus[6] =12;
		
		plats[7] ="Foie a la graella amb fruits del bosc";
		preus[7] =16;
		
		plats[8] ="Amanida tèbia de verdures";
		preus[8] =18;
		
		plats[9] ="Ou Mollet amb múrgules";
		preus[9] =25;
		
		plats[10] ="Gelats i sorbets artesans";
		preus[10] =10;
		
		plats[11] ="Coulant d'avellana";
		preus[11] =12;
		
		plats[12] ="Mil fulls de nata i maduixetes del bosc";
		preus[12] =12;
		
		plats[13] ="Fruita del temps";
		preus[13] =8;
		
		plats[14] ="Amanida de fruites de temporada";
		preus[14] =11;
		
	}

}
