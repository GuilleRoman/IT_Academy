package N1;

import java.util.HashMap;
import java.util.Map;

public class Fase_3 {

	private static HashMap<Character, Integer> lletres = new HashMap<Character, Integer>();
	
	/**
	 * main 
	 * 
	 * @param args	String[]
	 */
	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M2  Nivell 1 Fase 3 \n");
		
		String nom="Lionel Messi";
		System.out.println("Nom : "+nom+"\n");
		
		omplirMap(nom);
		
		mostrarMap();
		
	}
	
	
	/**
	 * omplirMap
	 * 
	 * Afegirm la clau (caracter) i el nombre de vegades que es continguda a la variable nom
	 * 
	 * @param nom	String 	nom a inserir al HashMap de caràcters.
	 * 
	 */
	public static void omplirMap(String nom) {
		int valor=0;
		
		// Recorrem l'string caracter a caracter
		for(int i=0; i<nom.length();i++) {
			
			// Si existeix la lletra al hashmap augmentem el seu valor.
			if(lletres.containsKey(nom.charAt(i))){
				valor=lletres.get(nom.charAt(i));
				valor++;
				lletres.put(nom.charAt(i), valor);
			}else { // Si no existeix la lletra al hashmap l'inserim amb valor 1.
				lletres.put(nom.charAt(i), 1);				
			}
			
		}
	}
	
	/**
	 * mostrarMap
	 * 
	 * Recorre el HashMap i mostra les claus i els valors emmagatzemats.
	 * 
	 */
	public static void mostrarMap() {
		
		for(Map.Entry<Character, Integer> entrada : lletres.entrySet()) {
			System.out.println("Clau : "+entrada.getKey()+"  Valor : "+entrada.getValue());
		}
		
	}

}
