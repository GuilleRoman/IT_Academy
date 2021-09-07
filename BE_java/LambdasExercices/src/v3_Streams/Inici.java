// https://www.youtube.com/watch?v=rfUhmchMOsM&list=PLK6RrRW5qdCMccvDnZb6-0d6uAIwbTQ1A&index=13
package v3_Streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

public class Inici {

	static Random random = new Random();
	
	
	public static void main(String[] args) { 	
	
		        Flujo.proveir(10, Inici::randomInt) 	 // Flujo<Integer>						     // = Flujo.proveir(10, ()->randomInt())
				.filtrar(valor -> valor>10)					// Flujo<Integer> primers				  	// .filtrar(valor -> esSenar(valor))
				.ordena(Integer::compareTo)				   	   // Flujo<Integer> primers,ordenats 		   //.ordenar((valor1,valor2)-> valor1-valor2)	.ordena(Integer::compare)<mètode static>
				.transformar(NumberUtils::elevarQuadrat)	  // Flujo<Integer> primers,ordenats,^2       // .transformar(valor -> elevarQuadrat(valor))
				.transformar(Descripcio::new) 				 // Flujo<Descripcio>					   	 // Transformem en String els valors Integers	.transformar(valor -> new Descripcio(valor))	
				.actuar(System.out::println)											              	// .actuar(valor -> System.out.println(valor))
				.transformar(Descripcio::getValue) 			//Flujo<Integer> primers,ordenats,^2       // .transformar(descripcio -> descripcio.getValue())
				.max(Comparator.naturalOrder())												  // .max((valor1,valor2) -> valor1-valor2);  .max(Integer::compare);  .max(Integer::compareTo);
				.ifPresentOrElse(
						valor -> System.out.println("màxim maxim.isPresent() inserit = " + valor.doubleValue()),
						() -> System.out.println("No hi ha màxim perquè el fluxe està buit.....")
				);
		        
		        
		
				/** Gestió de valors per tractar els valors nulls en la llista de valors amb Optional<>
				maxim.ifPresent(valor -> System.out.println("màxim maxim.isPresent() = " + valor.doubleValue()));
				
				double maxDouble = maxim.orElse(0).doubleValue();
				System.out.println("màxim  maxim.orElse = "+maxDouble);
				
				double maxDouble1 = maxim.orElseGet(() -> getMaximNull());
				System.out.println("màxim  orElseGet = "+maxDouble1); **/
				
				/**
				if(maxim.isPresent()) {
					double maxDouble = maxim.get().doubleValue();
					System.out.println("màxim  = "+maximDouble);
				} **/
				
				
				//.reducir(0,(Integer::sum));			     										  // .reducir(0,((valor1, valor2) -> Integer.sum(valor1, valor2)));				
			   //System.out.println("Reducció = "+total);	
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