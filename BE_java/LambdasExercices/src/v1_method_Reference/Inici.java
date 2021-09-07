// https://www.youtube.com/watch?v=rfUhmchMOsM&list=PLK6RrRW5qdCMccvDnZb6-0d6uAIwbTQ1A&index=13
package v1_method_Reference;

import java.util.Random;

public class Inici {

	static Random random = new Random();
	
	
	public static void main(String[] args) { 	
	
		Integer total =  Flujo.proveir(10, Inici::randomInt) 	 // Flujo<Integer>						     // = Flujo.proveir(10, ()->randomInt())
				.filtrar(NumberUtils::esSenar)					// Flujo<Integer> senars				  	// .filtrar(valor -> esSenar(valor))
				.ordena(Integer::compareTo)				   	   // Flujo<Integer> senars,ordenats 		   //.ordenar((valor1,valor2)-> valor1-valor2)	.ordena(Integer::compare)<mètode static>
				.transformar(NumberUtils::elevarQuadrat)	  // Flujo<Integer> senars,ordenats,^2        // .transformar(valor -> elevarQuadrat(valor))
				.transformar(Descripcio::new) 				 // Flujo<Descripcio>					   	 // Transformem en String els valors Integers	.transformar(valor -> new Descripcio(valor))	
				.actuar(System.out::println)											              	// .actuar(valor -> System.out.println(valor))
				.transformar(Descripcio::getValue) 			//Flujo<Integer> senars,ordenats,^2        // .transformar(descripcio -> descripcio.getValue())
				.reducir(0,(Integer::sum));				     										  // .reducir(0,((valor1, valor2) -> Integer.sum(valor1, valor2)));
				
		System.out.println("Reducció = "+total);	
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