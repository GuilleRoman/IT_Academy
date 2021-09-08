package Nivell_2;

import java.util.Arrays;
import java.util.Comparator;


public class Nivell_2 {

	private static String[] matriu = {"Joel","5","Carmeta","34","Anna","23","Joanet","4","123","Marc","33","Aina","pol"} ;
	
	public static void main(String[] args) {
		
		Nivell_2 n2 = new Nivell_2();
				
		// ordena per longitud (de més curta a més llarga)
		System.out.println("- ordena per longitud (de més curta a més llarga)");
		n2.ordenarLongitud(matriu, true);
		
		// longitud inversa (de  més llarga a més curta)
		System.out.println("\n- ordena per longitud (de més llarga a més curta)");
		n2.ordenarLongitud(matriu, false);
		
		// alfabèticament pel primer caràcter (Nota: charAt (0) retorna el codi numèric del primer caràcter)
		System.out.println("\n- ordenar alfabèticament pel primer caràcter");
		Arrays.stream(matriu)
		.sorted(Comparator.comparing(valor -> valor.charAt(0)))
		.forEach(System.out::println);	
		
		// Les cadenes que contenen "e" primer, tota la resta en segon lloc.
		System.out.println("- ordena per les cadenes que contenen e primer, tota la resta en segon lloc.");
		n2.conteCadena(matriu, "e");
		
		//Modifica tots els elements de la matriu per canviar els caracters “a” a “4” 
		System.out.println("\n- Modifica tots els elements de la matriu per canviar els caracters “a” a “4” ");
		n2.reemplaça(matriu, "a","4");
		
		// Mostra només els elements que siguin 100% numerics. (tot i que estigui guardats com strings)
		System.out.println("\n- Mostra només els elements que siguin 100% numerics. (tot i que estigui guardats com strings)");
		n2.numerics(matriu);
		
		
		//	Crea una Functional Interface que continga un mètode abstracte operacio (), que retorne un valor float; 
		//	injecta a la interfície creada mitjançant una lambda el cos del mètode, de manera que pugis transformar 
		//	la operació a una suma, resta, multiplicació i divisio.
		System.out.println("\n- Crea una Functional Interface que continga un mètode abstracte operacio ().");
		System.out.println("- Injecta una lambda de manera que pugis transformar l'operació en suma,resta,multiplicació, i divisió.");
		int v1 = 10;
		int v2 = 5;	
		operacionsBasiques ob;
		
		ob = (() -> v1+v2) ;
		System.out.println(v1+" + "+v2+" = "+ob.operacio());
		
		ob = (() -> v1-v2) ;
		System.out.println(v1+" - "+v2+" = "+ob.operacio());
		
		ob = (() -> v1*v2) ;
		System.out.println(v1+" x "+v2+" = "+ob.operacio());
		
		ob = (() -> v1/v2) ;
		System.out.println(v1+" / "+v2+" = "+ob.operacio());
		
	}
	
	/**
	 * ordenarLongitud
	 * 
	 * ordena per longitud  asc true  de més curta a més llarga
	 * 						asc false de més llarga a més curta
	 * 
	 * @param llista	String[]
	 * @param asc		Boolean
	 */
	private void ordenarLongitud(String[] llista, Boolean asc) {
		if(asc) {
			Arrays.stream(llista)
				.sorted(Comparator.comparing(valor -> valor.length()))
				//.collect(Collectors.toList())
				.forEach(System.out::println);
		}else {
				Arrays.stream(llista)
					.sorted(Comparator.comparing(String::length).reversed())			
					.forEach(System.out::println);
		}
	}
	
	/**
	 * conteCadena
	 * 
	 * Mostra les cadenes que contenen c primer, seguidament mostra tota la resta.
	 * 
	 * @param llista	String[]
	 * @param c			String
	 */
	private void conteCadena(String[] llista, String c) {
		 Arrays.stream(llista)
		 	.sorted(Comparator.comparing((String v) -> v.toLowerCase().contains(c)).reversed())
			.forEach(System.out::println);
	}
	
	/**
	 * reemplaça
	 * 
	 * Sustitiueix a les cadenes el valorAntic pel valorNou
	 * 
	 * @param llista		String[]
	 * @param valorAntic	String
	 * @param nouValor		String	
	 */
	public void reemplaça(String[] llista, String valorAntic, String nouValor) {
		Arrays.stream(llista)
			.map (valor -> valor.replace(valorAntic, nouValor))
			.forEach(System.out::println);
	}
	
	/**
	 * numèrics
	 * 
	 * Mostra els valors que son numèrics
	 * 
	 * @param llista	String[]
	 * 
	 */
	public void numerics(String[] llista) {
		String valorsNumerics = "[0-9]+";
		
		Arrays.stream(llista)
		.filter( valor -> valor.matches(valorsNumerics))
		.forEach(System.out::println);
		
	}
}
