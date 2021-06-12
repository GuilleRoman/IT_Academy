package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_3 {
	
	private static List<String> llistaCiutats = new ArrayList<String>();
	private static List<String> llistaCiutatsModificades = new ArrayList<String>();
	
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String strCanvi;
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 3 \n");
		
		inserirCiutats();
		
		for(String str : llistaCiutats) {
			strCanvi = str.replaceAll("a", "4");			
			llistaCiutatsModificades.add(strCanvi);
		}
		
		System.out.println("Llista original   : "+llistaCiutats);
		System.out.println("Llista modificada : "+llistaCiutatsModificades);
		
	}
	
	
	
	/**
	 * inserirCiutats
	 * 
	 * Afegeix a l'ArrayList les 6 ciutats.
	 */
	public static void inserirCiutats() {
		llistaCiutats.add("Barcelona");
		llistaCiutats.add("València");
		llistaCiutats.add("Malaga");
		llistaCiutats.add("Cadis");
		llistaCiutats.add("Madrid");
		llistaCiutats.add("Santander");
	}

}
