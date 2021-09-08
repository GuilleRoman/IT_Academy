package NIVELL_1.Fase1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fase_1 {
	
	static Random aleatori = new Random();

	public static void main(String[] args) {
		
		System.out.println("M10 LAMBDAS, STREAMS\n");
		
		
		//Creació d'una llista de cadenes de noms propis,
		System.out.println("- Mètode que retorne una llista de totes les cadenes que comencen amb la lletra 'a' (mayuscula) i tenen exactament 3 lletres.");
		List<String> llistaNoms = Arrays.asList("Ana","Joan","Aina","Rosa","Mar","Joanna","Ane","ant");
		System.out.println("Llista inicial de noms : "+llistaNoms);
		
		List<String> resultat =llistaNoms.stream()							// Creem el fluxe
			.filter( (nom) -> nom.length()==3 & nom.charAt(0)=='A')		   // Apliquem el filtre amb el bipredicate 3 caractes i comenci per A.
			.peek(System.out::println)									  // Imprimim el resultat però mantenint un fluxe de dades.	
			.collect(Collectors.toList());								 // Recolectem les dades de l'streem cap a una estructura de dades tipus List.
			
		// Mostrem per cònsola la llista creada.
		System.out.println("Noms amb 3 caràcters i que comencim per A : "+resultat);
		
		
		//Escriu un mètode que retorne una cadena separada per comes basada en una llista d’Integers.
		System.out.println("\n- Mètode que retorne una cadena separada per comes basada en una llista d’Integers.");
		String cadena = generaStringInt(creaLlistaSencers(10, 1, 10));
		System.out.println("\nCadena de sencers : "+cadena);
		
		// mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat. 
		System.out.println("\n- Mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’.");
		List<String> llistaStrings = Arrays.asList("Ana","Joanet","Aina","Rosa","Mar","Joanna","Ane","antoni");
		System.out.println("Lista Inicial de cadenes :"+llistaStrings);
		
		System.out.println(conteElCaracter(llistaStrings, 'o', 0));
		
		// mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat. 
		System.out.println("\n- Mètode que retorne una llista de totes les cadenes que continguen la lletra ‘o’ i longitud superior a 5 caràcters.");
		System.out.println(conteElCaracter(llistaStrings, 'o', 5));
		
		// Imprimir llista dels mesos de l'any
		System.out.println("\n- Imprimir llista dels mesos de l'any");
		List<String> llistaMesos = Arrays.asList("gener","febrer","març","abril","maig","juny","juliol","agost","setembre","octubre","novembre","desembre");
		llistaMesos.stream()
			.forEach(mes ->System.out.print(mes+" "));
		System.out.println();
		
		
		// Imprimir llista dels mesos de l'any mitjançant method reference.
		System.out.println("\n- Imprimir llista dels mesos de l'any method reference");
		llistaMesos.stream()
			.map(mes -> mes+" ")
			.forEach(System.out::print);		
	}
	
	/**
	 * conteElCaracter
	 * 
	 * Retorna els strings de la llista que contenen el caràcter passat com a paràmetre.
	 * 
	 * @param llista			List<String>
	 * @param car				char
	 * @return	llistaFinal		List<String>		
	 */
	// string.indexOf('a').   returns the the index of the first occurrence , or -1 if the character does not occur.
	public static List<String> conteElCaracter(List<String> llista, char car, int minim){
		
		List<String>llistaFinal = llista.stream()
				.filter((cadena) -> cadena.indexOf(car)!= -1 & cadena.length()>minim)
				.collect(Collectors.toList());
				
		return llistaFinal;
	}
	
	
	/**
	 * crearLlistaSencers
	 * Crea una llista de n elements de nombres de tipus Integer
	 * 
	 * @param	elements		int		Nombre d'elements de la llista
	 * @param	rangInf			int 	Rang inferior
	 * @param	rangSup			int 	Rang superior
	 * 
	 * @return	llistaSencers	List<Integer>
	 */
	public static List<Integer> creaLlistaSencers(int elements, int rangInf, int rangSup){
		
		List<Integer> llistaSencers = aleatori.ints(elements, rangInf, rangSup)
				.boxed()
				.collect(Collectors.toList());
				
		
		return llistaSencers;
	}
	
	
	
	/** 
	 * generaLlistaInt 
	 * mètode que retorne una cadena separada per comes basada en una llista d’Integers.
	 * 
	 * @return	String
	 */	
	public static String generaStringInt(List<Integer> llistaSencers ) {		
		
		  String cadenaSencers = llistaSencers.stream()											  
				  .distinct()								  						  // Elimino els valors repetits.	
				  .sorted(Comparator.naturalOrder())		 					     // Ordeno de menor a major -odre natural-.
				  .peek(sencer -> System.out.print(sencer+" "))						// Mostrem per cònsola la llista de nombres sencers.				  
				  .map(sencer -> (sencer % 2 == 0) ? "e"+sencer : "o"+sencer) 	   // Mapejo i transformo els integers en Strings amb el prefixe corresponent.
				  .collect(Collectors.joining(","));				  			  //  Recolecto i join	dels elements separts per comes.
		 		
		 return cadenaSencers;
	}
	
}
