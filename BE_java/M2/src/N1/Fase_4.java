package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_4 {

	private static List<Character> name = new ArrayList<Character>();
	private static List<Character> surName = new ArrayList<Character>();
	private static List<Character> fullName = new ArrayList<Character>();
	
	
	public static void main(String[] args) {
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M2  Nivell 1 Fase4 \n");
		
		//Omplim les llistes name i surName
		omplirLlista(name, "Joan");		
		omplirLlista(surName, "Campos");
		
		//Mostrem les llistes Name i Surname
		System.out.println("Nom   : "+name);
		System.out.println("Cognom: "+surName);
		
		// Fusionem les llistes name i surname a una nova llista anomenada fullName
		fullName.addAll(name);
		fullName.add(' ');
		fullName.addAll(surName);
		
		// Mostrem la llista fusionada -fullName-
		System.out.println("Nom Sencer : "+fullName);
		
	}
	
	/**
	 * omplirLlista
	 * 
	 * Omple la llista de caràctes pasada com a paràmetre amb el String passat per paràmetre
	 * 
	 * @param llista	List	Llista on insertar la cadena
	 * @param cadena	String 	cadena a inserir a la llista de caràcters.
	 */
	private static void omplirLlista(List<Character> llista, String cadena) {
		for(int i=0; i<cadena.length();i++) {
			llista.add(cadena.charAt(i));
		}
		
	}
	

}
