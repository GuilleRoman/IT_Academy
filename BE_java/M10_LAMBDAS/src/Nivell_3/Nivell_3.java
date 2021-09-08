package Nivell_3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Nivell_3 {

	public static void main(String[] args) {
		Nivell_3 n3 = new Nivell_3();
		
		// Generem el llistat d'alumnes.
		List<Alumne> llistatAlumnes = n3.generarLlistatAlumnes();
		
		// Mostra per pantalla el nom i l’edat de cada alumne. 
		System.out.println("Mostra per pantalla el nom i l’edat de cada alumne : ");
		llistatAlumnes.stream()
			.forEach(valor-> System.out.println(valor.getNom()+" "+valor.getEdat()+" anys"));
		
		//Filtra la llista per tots els alumnes que el nom comensi per “a”, asigna-ho a un altre llista y mostra per pantalla la nova llista (tot amb lambdas) 
		System.out.println("\nFiltra la llista per tots els alumnes que el nom comensi per a,"
				+ "\n asigna-ho a un altre llista y mostra per pantalla la nova llista (tot amb lambdas)");
		llistatAlumnes.stream()
			.filter(valor -> valor.getNom().charAt(0)=='A')			//Stream<Alumne>
			.collect(Collectors.toList())						   // List<Alumne>
			.forEach(System.out::println);
		
		// mostra per pantalla els alumnes que tinguin un 5 o mes de nota. 
		System.out.println("\nMostra per pantalla els alumnes que tinguin un 5 o més de nota.");
		llistatAlumnes.stream()
		.filter(valor -> valor.getNota()>=5)			
		.forEach(System.out::println);
		
		// Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota y que no siguin de PHP. 
		System.out.println("\nMostra per pantalla els alumnes que tinguin un 5 o més de nota y que no siguin de PHP. ");
		llistatAlumnes.stream()
		.filter(valor -> valor.getNota()>=5 & valor.getCurs()!="PHP")			
		.forEach(System.out::println);
		
		// Mostra tots els alumnes que facin JAVA i siguin majors d’edat. 
		System.out.println("\nMostra tots els alumnes que facin JAVA i siguin majors d’edat. ");
		llistatAlumnes.stream()
		.filter(valor -> valor.getCurs().equals("JAVA") & valor.getEdat()>=18)			
		.forEach(System.out::println);
	}
	
	/**
	 * generarLlistaAlumnes
	 * 
	 * Genera una llista amb 10 Alumnes
	 * 
	 * @return	llistat		List<Alumne>
	 */
	public List<Alumne> generarLlistatAlumnes(){
		List<Alumne> llistat = new ArrayList<Alumne>();
		
		llistat.add(new Alumne ("Carla Mena", 17, "PHP", 7.25 ));
		llistat.add(new Alumne ("Joan Estruch", 16, "PHP", 3.45 ));
		llistat.add(new Alumne ("Aina Calabuig", 17, "JAVA", 5.15 ));
		llistat.add(new Alumne ("Mariona Caserres", 19, "JAVA", 8.25 ));
		llistat.add(new Alumne ("Pep Prieto", 18, "JAVA", 6.50 ));
		llistat.add(new Alumne ("Rosa Regàs", 21, "HTML", 3.55 ));
		llistat.add(new Alumne ("Marc Armengol", 20, "HTML", 7.25 ));
		llistat.add(new Alumne ("Marina Heredia", 22, "PYTHON", 4.25 ));
		llistat.add(new Alumne ("Anna Soler", 21, "PYTHON", 6.15 ));
		llistat.add(new Alumne ("Pau Casals", 22, "PYTHON", 7.50 ));
		
		return llistat;
	}
}
