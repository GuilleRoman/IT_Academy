package N1;

import java.util.HashMap;
import java.util.Map;

public class Fase_3 {

	private static HashMap<Character, Integer> lletres = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		String nom="Lionel Messi";
		System.out.println("Nom : "+nom+"\n");
		
		omplirMap(nom);
		
		mostrarMap();
		
	}
	
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
	
	public static void mostrarMap() {
		
		for(Map.Entry<Character, Integer> entrada : lletres.entrySet()) {
			System.out.println("Clau : "+entrada.getKey()+"  Valor : "+entrada.getValue());
		}
		
	}

}
