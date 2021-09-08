package Nivell_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Nivell_2 {

	private static String[] matriu = {"Joel","5","Carmeta","34","Anna","23","Joanet","4","123","Marc","33","Aina","pol"} ;
	private static Random aleatori = new Random();
	
	public static void main(String[] args) {
		
		Nivell_2 n2 = new Nivell_2();
				
		// ordena per longitud (de m�s curta a m�s llarga)
		System.out.println("- ordena per longitud (de m�s curta a m�s llarga)");
		n2.ordenarLongitud(matriu, true);
		
		// longitud inversa (de  m�s llarga a m�s curta)
		System.out.println("\n- ordena per longitud (de m�s llarga a m�s curta)");
		n2.ordenarLongitud(matriu, false);
		
		// alfab�ticament pel primer car�cter (Nota: charAt (0) retorna el codi num�ric del primer car�cter)
		System.out.println("\n- ordenar alfab�ticament pel primer car�cter");
		Arrays.stream(matriu)
		.sorted(Comparator.comparing(valor -> valor.charAt(0)))
		.forEach(System.out::println);	
		
		// Les cadenes que contenen "e" primer, tota la resta en segon lloc.
		System.out.println("- ordena per les cadenes que contenen e primer, tota la resta en segon lloc.");
		n2.conteCadena(matriu, "e");
		
		//Modifica tots els elements de la matriu per canviar els caracters �a� a �4� 
		System.out.println("\n- Modifica tots els elements de la matriu per canviar els caracters �a� a �4� ");
		n2.reempla�a(matriu, "a","4");
		
		// Mostra nom�s els elements que siguin 100% numerics. (tot i que estigui guardats com strings)
		System.out.println("\n- Mostra nom�s els elements que siguin 100% numerics. (tot i que estigui guardats com strings)");
		n2.numerics(matriu);
		
		
		//	Crea una Functional Interface que continga un m�tode abstracte operacio (), que retorne un valor float; 
		//	injecta a la interf�cie creada mitjan�ant una lambda el cos del m�tode, de manera que pugis transformar 
		//	la operaci� a una suma, resta, multiplicaci� i divisio.
		System.out.println("\nCrea una Functional Interface que continga un m�tode abstracte operacio ().");
		System.out.println("Injecta una lambda de manera que pugis transformar l'operaci� en suma,resta,multiplicaci�, i divisi�.");
		int valor1 = 10;
		int valor2 = 5;	
		operacionsBasiques ob;
		
		ob = ((v1,v2) -> v1+v2) ;
		System.out.println(valor1+" + "+valor2+" = "+ob.operacio(valor1, valor2));
		
		ob = ((v1,v2) -> v1-v2) ;
		System.out.println(valor1+" - "+valor2+" = "+ob.operacio(valor1, valor2));
		
		ob = ((v1,v2) -> v1*v2) ;
		System.out.println(valor1+" x "+valor2+" = "+ob.operacio(valor1, valor2));
		
		ob = ((v1,v2) -> v1/v2) ;
		System.out.println(valor1+" / "+valor2+" = "+ob.operacio(valor1, valor2));
		
	}
	
	
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
	
	private void conteCadena(String[] llista, String c) {
		 Arrays.stream(llista)
		 	.sorted(Comparator.comparing((String v) -> v.toLowerCase().contains(c)).reversed())
			.forEach(System.out::println);
	}
	
	public void reempla�a(String[] llista, String valorAntic, String nouValor) {
		Arrays.stream(llista)
			.map (valor -> valor.replace(valorAntic, nouValor))
			.forEach(System.out::println);
	}
	
	public void numerics(String[] llista) {
		String valorsNumerics = "[0-9]+";
		
		Arrays.stream(llista)
		.filter( valor -> valor.matches(valorsNumerics))
		.forEach(System.out::println);
		
	}
}
