package N1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Fase_2 {

	public static Scanner lector = new Scanner(System.in);
	private static List<String> llistaCiutats = new ArrayList<String>();
	
	
	/**
	 * main 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 2 \n");

		demanarCiutats(6);
		
		System.out.println("Les ciutats inserides són   : "+llistaCiutats);
		
		//ordeno la Col·lecció ArrayList
		Collections.sort(llistaCiutats);
		
		System.out.println("Les ciutats un cop ordenades : "+llistaCiutats);
		
	}
	
	
	public static void demanarCiutats(int nombre) {
		System.out.println("Introdueix "+nombre+" noms de ciutats: ");
		
		for(int i = 0; i<nombre; i++) {
			System.out.print ("Introdueix la ciutat núm. "+i+" :");			
			llistaCiutats.add(llegirCadena());
			System.out.println();
		}
		
	}
	
	
	/**
	 * llegirCadena
	 * 
	 * Llegeix una línia de text del teclat i l'emma a un String
	 * 
	 * LLegeig
	 * @return	cadena	String 	
	 */
	public static String llegirCadena() {
		
		String cadena;
		
		do {			
			
			cadena = lector.nextLine();
			
			if(cadena.length()==0) {
				System.out.print("Error: cadena buida, torna a inserir-la : ");
			}
			
		}while (cadena.length()==0);	
		
		return cadena;
	}

}
