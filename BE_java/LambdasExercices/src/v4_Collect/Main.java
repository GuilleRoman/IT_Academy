package v4_Collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		List<Book> llibres = Arrays.asList(
				new Book("345-89", "Els catalans als camps nazis", 1918, Genre.TERROR),
				new Book("923-45", "Brigadistes", 1998, Genre.THRILLER),
				new Book("978-25", "El capital", 2017, Genre.COMEDY),
				new Book("923-45", "Brigadistes", 1998, Genre.THRILLER),
				new Book("978-25", "Catalunya any zero", 2017, Genre.THRILLER)
		);
		
		
		// --- Recolecció cap a una llista modificable ---------------------------------------
		System.out.println("Recolecció cap a una llista modificable   - Collectors.toList()\n");
		List<Book> resultat = llibres.stream()
					.filter(book -> book.getAnyPublicacio() <2000)
					.collect(Collectors.toList()
		);
		
		resultat.add(new Book("345-89", "Els catalans als camps nazis 0", 1992, Genre.TERROR));
		System.out.println(resultat);
		
		// --- Recolecció cap a una llista no modificable ---------------------------------------
		System.out.println("Recolecció cap a una llista no modificable   - Collectors.toList()\n");
		List<Book> resultatNoModificable = llibres.stream()
					.filter(book -> book.getAnyPublicacio() <2000)
					.collect(Collectors.toUnmodifiableList()
		);
				
		//resultatNoModificable.add(new Book("345-89", "Els catalans als camps nazis 0", 1992, Genre.TERROR));
		System.out.println(resultatNoModificable);
		
		// --- Recolecció cap a un conjunt   SET  -------------------------------------------------------
		System.out.println("Recolecció cap a un Conjunt SET  modificable   - Collectors.toSet()\n");
		Set<Book> resultatSet = llibres.stream()
				.filter(book -> book.getAnyPublicacio() < 2000)
				.collect(Collectors.toSet());
		
		// Per evitar que el conjunt SET no accepti registres repetits, cal implementar el mètode equals a la classe Book
		// Per evitar modificacions posteriors del SET cal fer servir la classe Collectors.toUnmodificableSet()
		System.out.println("Afegeixo un nou llibre un cop resolt l' stream ");
		System.out.println("345-90  Els catalans als camps nazis , 1992, Genre.TERROR");
		resultatSet.add(new Book("345-90", "Els catalans als camps nazis 0", 1992, Genre.TERROR));
		System.out.println(resultatSet);
		
		
		
		// --- Recolecció cap a un conjunt SET (TREESET)     - Collectors.toCollection(TreeSet::new) ------------------
		System.out.println("Recolecció cap a un Conjunt SET (TREESET)     - Collectors.toCollection(TreeSet::new)\n");
		Set<Book> resultatTreeSet = llibres.stream()
				.filter(book -> book.getAnyPublicacio() < 2000)
				.collect(Collectors.toCollection(TreeSet::new));	//.collect(Collectors.toCollection(() -> new TreeSet<>()));

		// Per evitar que el conjunt SET no accepti registres repetits, cal implementar el mètode equals a la classe Book
		// Quan fem servir un TreeSet cal implementar la Interface Comparable a la classe Book
		
		System.out.println("Afegeixo un nou llibre un cop resolt l' stream ");
		System.out.println("345-90  Els catalans als camps nazis , 1992, Genre.TERROR");
		resultatTreeSet.add(new Book("345-90", "Els catalans als camps nazis 0", 1992, Genre.TERROR));
		System.out.println(resultatTreeSet);	
		
		
		// --- Recolecció cap a una col·lecció MAP (i)    Collectors.toMap(clau, valor) ---------------------------------
		System.out.println("Recolecció cap a una Col·lecció MAP     - Collectors.toMap(clau, valor)\n");
		Map<String,Book> resultatMap = llibres.stream()
				.filter(book -> book.getAnyPublicacio() < 2000)
				.distinct()		// Eliminem els repetits en base a l'equals de la classe Book, així evitem errors de claus duplicades.
				.collect(Collectors.toMap(Book::getIsbn, Function.identity()));
																	
		System.out.println("Afegeixo un nou llibre un cop resolt l' stream ");
		System.out.println("345-90  Els catalans als camps nazis , 1992, Genre.TERROR");
		//resultatMap.add(new Book("345-90", "Els catalans als camps nazis 0", 1992, Genre.TERROR));
		System.out.println(resultatMap);		

		// --- Recolecció cap a una col·lecció MAP (ii) Collectors.toMap(clau, valor, BinariOperator) ---------------------------------
		System.out.println("Recolecció cap a una Col·lecció MAP (ii)    - Collectors.toMap(clau, valor, BinariOperator, mapSupplier)\n");
		Map<String, Book> resultatMap1 = llibres.stream()
				.filter(book -> book.getAnyPublicacio() < 2000) 
				.collect(Collectors.toMap(	Book::getIsbn, 
											Function.identity(), 
											(book1, book2)-> new Book(book1.getIsbn(), book1.getTitol()+"--R",book1.getAnyPublicacio(),book1.getGenre()),
											TreeMap::new)
				);
		
		System.out.println(resultatMap1);
		
		
		
	}
	
	
	
	

}
