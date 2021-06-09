package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_4 {

	private static List<Character> name = new ArrayList<Character>();
	private static List<Character> surName = new ArrayList<Character>();
	private static List<Character> fullName = new ArrayList<Character>();
	
	
	public static void main(String[] args) {
		
		omplirLlista(name, "Joan");		
		omplirLlista(surName, "Campos");
		System.out.println("Nom   : "+name);
		System.out.println("Cognom: "+surName);
		fullName.addAll(name);
		fullName.add(' ');
		fullName.addAll(surName);
		System.out.println("Nom Sencer : "+fullName);
		
	}
	
	private static void omplirLlista(List<Character> llista, String cadena) {
		for(int i=0; i<cadena.length();i++) {
			llista.add(cadena.charAt(i));
		}
		
	}
	

}
