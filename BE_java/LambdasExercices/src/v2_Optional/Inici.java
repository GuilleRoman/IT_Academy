// https://www.youtube.com/watch?v=rfUhmchMOsM&list=PLK6RrRW5qdCMccvDnZb6-0d6uAIwbTQ1A&index=13
package v2_Optional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import v3_Streams.Student;

public class Inici {

	static Random random = new Random();
	
	
	public static void main(String[] args) { 	
		// font de les dades
		ArrayList<String> noms = new ArrayList<>(List.of("Pere","Laia","Neus","Núria","Nausica"));
		
		// Stream que no retorna cap tipus de valor.
		noms.stream()								// 1.- funció generadora de l'stream
			.filter(nom -> nom.contains("N")) 	   // 2.- Operacions intermitjes
			.map(nom -> nom.length())		      // 2.- Operacions intermitjes
			.forEach(System.out::println);		 // 3.- Operació terminal o final	
		
		// Stream que retorna una llista de tipus String
		List<String> resultat = noms.stream()
				.filter(nom -> nom.contains("N"))
				.collect(Collectors.toList());
		
		resultat.forEach(System.out::println);
		
		//Generar sobre la marxa una font de dades  (ilimitades si no les limitem amb operacions intermitjes o finals.
		
		// Stream.generate()
		System.out.println("\n- Stream.generate( ()-> {})");
		List<Integer> llistaSencers = Stream.generate(() -> {
			int next = random.nextInt(10);
			System.out.println("Generat el valor :"+next);
			return next;
		})
				.limit(5)
				.collect(Collectors.toList());		
		System.out.println(llistaSencers);
				
		 // Stream.iterate(seed, unariOperator)
		// Stream.iterate(seed,predicate,UnaryOperator)  valor inicial, predicat, operació unaria.
		System.out.println("\n- Stream.iterate(seed,UnaryOperator)  valor inicial, operació unaria.");
		List<Integer> llistaSencers5 = Stream.iterate (1, valor -> valor * 5)
				.limit(3)
				.collect(Collectors.toList());		
		System.out.println(llistaSencers5);
		
		// Stream.iterate(seed, predicate, unariOperator)
       // Stream.iterate(seed,UnaryOperator)  valor inicial, predicate, operació unaria.
	   System.out.println("\n- Stream.iterate (seed, predicate, UnariOperator)  ");
	   List<Integer> llistaSencers_1000 = Stream.iterate (1, valor -> valor<1000, valor -> valor * 5)
				.collect(Collectors.toList());		
	   System.out.println(llistaSencers_1000);	
		
		//Generador de nombres sencers aleatoris.
		// Classe Random.ints(nombre elements, limitInferior, limitSuperior);
		// El tipus de la llista és de tipus - IntStream llistaSencersAleatoris1 = random.ints(5, 0, 10);		
		System.out.println("\n- Random.ints(5, 0, 10)  ");
		List<Integer> llistaSencersAleatoris = random.ints(5, 0, 10)	// 
				.boxed().collect(Collectors.toList());		// boxed() converteix el tipus IntStream en el primitivo Integer. 
		System.out.println(llistaSencersAleatoris);	
		
		// Interface IntStream    mètode static range   IntStream.range(start, endExclusive) Retorna un IntStream ordenat dels elements compresos entre start i endExclusive-1
		// IntStream.rangeClosed(start, endInclusive)   elements ordenats compresos entre start i endInclusive
		System.out.println("\n- IntStream.range  ");
		List<Integer> llistaSencersSequencials = IntStream.range(0, 11)	 
				.boxed().collect(Collectors.toList());		// boxed() converteix el tipus IntStream en el primitivo Integer. 
		System.out.println(llistaSencersSequencials);	
		
		// Interface IntStream    mètode static range   IntStream.range(start, endExclusive) Retorna un IntStream ordenat dels elements compresos entre start i endExclusive-1
	   // IntStream.rangeClosed(start, endInclusive)   elements ordenats compresos entre start i endInclusive
	   System.out.println("\n- IntStream.range   passa elements de tipus integer a String via .map");
	   List<String> llistaSencersToString = IntStream.range(0, 11)	 
			.boxed()
			.map(sencer -> "valor"+sencer)
			.collect(Collectors.toList());		// boxed() converteix el tipus IntStream en el primitivo Integer. 
	   System.out.println(llistaSencersToString);
		
	   System.out.println("\n- flatMap de n Streams<Integer>");
	   List<Integer> resultat1 = Stream.of(2, 4, 6)
			   		.flatMap(Inici::getRandomNumbers)
			   		.collect(Collectors.toList());
	   System.out.println(resultat1);
	   
	   
	   System.out.println("\n- peek vs forEach ");
	   List<Integer> resultat2 = Stream.of(2, 4, 6)
	   	.peek(System.out::println)
	   	.collect(Collectors.toList());
	   System.out.println(resultat2);
	   
	   // Reducció *************************************************
	   
	   // sum()
	   System.out.println("\n- Reducció sum() en un IntStream");
	   int resultat4 = IntStream.range(1, 5)
			   .peek(valor -> System.out.print(valor+" "))
			   .sum();
	   System.out.println("\nLa suma dels elements és :"+resultat4);
	   
	   // max, min, average
	   System.out.println("\n- Reducció sum() en un Stream via mapToInt ");
	   int resultat5 = Stream.of(1, 2, 3, 4)
			   .peek(valor -> System.out.print(valor+" "))
			   .mapToInt(Integer::intValue)     				//.mapToInt(valor -> valor.intValue())
			   .sum();
	   System.out.println("\nLa suma dels elements és :"+resultat5);
	   
	  
	   // Stream.reduce (identitat, (ac, valor) -> acum +  valor)
	   System.out.println("\n- Reducció amb el mètode reduce de la clase Stream ");
	   Integer resultat6 = Stream.of(1, 2, 3, 4)
			   .filter(valor -> valor > 5)
			   .peek(System.out::print)
			   .reduce(1,(acumulador, valor) -> acumulador * valor);
			   
	   System.out.println("\nLa suma dels elements és :"+resultat6);
	   
		// Stream.reduce (identitat, (ac, valor) -> acum + valor)
		System.out.println("\n- Reducció amb reduce (identitat, BiFuntcion, Combiner) ");
		Integer resultat7 = Stream
				.of(new Student("manel", 20),
						new Student("lluis", 35), new Student("Anna", 23),
						new Student("Mariona", 5))
				.peek(student -> System.out.println(student.getNom() + "  -" + student.getEdat() + " "))
				.reduce(0,(parcial, student) -> parcial + student.getEdat(), (parcial1, parcial2) -> parcial1 + parcial2);
		// .reduce(identitat<Integer>, Bifunction<Integer, Student, Integer>,
		// BinaryOperator<Integer>combiner).
		// - Bifunction<Integer, Student, Integer> Calcula un resultat parcial.
		// - BinaryOperator <Integer> combiner El combinador calcula la suma dels
		// resultats parcials.
		System.out.println("\nLa suma de les edats dels estudiants és :" + resultat7);		 
	     
		// El mètode de la classe Random ens retorna un Stream de integers IntStream,
		System.out.println("\nMàxim  :");
		random.ints(10, 1, 10)
				.boxed() // Convertim el tipus IntStream en un Stream de Integers.
				.filter(valor -> valor > 5) // filtrem els valors majors de cinc.
				.sorted(Integer::compareTo) // ordenem, també podem ordenar amb Comparator.naturalOrder
				.map(NumberUtils::elevarQuadrat) // elevar al quadrat .map(valor -> valor*valor)
				.map(Descripcio::new) // Stream <Description>
				.peek(System.out::print) // Mostrem els valors via cònsola
				.map(Descripcio::getValue) // Stream <Integer>
				.max(Comparator.naturalOrder()) // max retorna un valor OptionalInteger.
				.ifPresentOrElse(valor -> System.out.println("màxim maxim.isPresent() inserit = " + valor),
						() -> System.out.println("No hi ha màxim perquè el fluxe està buit....."));	
		
		// El mètode de la classe Random ens retorna un Stream de integers IntStream,
		System.out.println("\nSuma  :");
		int valorSuma = random.ints(10, 1, 10)
				.boxed() 							  // Convertim el tipus IntStream en un Stream de Integers.
				.filter(valor -> valor > 5) 		 // filtrem els valors majors de cinc.
				.sorted(Integer::compareTo) 		// ordenem, també podem ordenar amb Comparator.naturalOrder.
				.map(NumberUtils::elevarQuadrat)   // elevar al quadrat .map(valor -> valor*valor)
				.map(Descripcio::new) 			  // Stream <Description>
				.peek(System.out::print) 		 // Mostrem els valors via cònsola.
				.map(Descripcio::getValue) 	    // Stream <Integer>
				.mapToInt(Integer::intValue)   // Convertim els Integers en int, i llavors tenim un fluxe IntStream.
				.sum();						  // Retorna un int amb la suma de tot els elements del IntStream.
				
		System.out.println("Valor de la suma dels elements : "+valorSuma);
		
		}
	
	
	
	public static Stream<Integer> getRandomNumbers(Integer size){
		return random.ints(size, 0, 11).boxed();
	}
	
	
	
	
	private static int getMaximNull() {
		return 0;
	}
	
	
	/**
	 * randomInt
	 * 
	 * @return int 
	 */
	private static int randomInt() {
		return random.nextInt(10);
	}
	
}