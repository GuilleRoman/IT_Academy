// https://www.youtube.com/watch?v=rfUhmchMOsM&list=PLK6RrRW5qdCMccvDnZb6-0d6uAIwbTQ1A&index=13
package v0_InterfacesFuncionalsStandars;

import java.util.Random;

public class Inici {

	private static Random random = new Random();
	
	
	public static void main(String[] args) {
		
		Integer total = Flujo.proveir(10, ()->randomInt())				
				.filtrar(valor -> valor %2 == 0)				
				.transformar(valor -> valor*valor)
				.actuar(valor -> System.out.println(valor))
				.reducir(0,((valor1, valor2) -> valor1 + valor2));
				
		System.out.println("Reducció = "+total);		
	}	
	
	
	private static int randomInt() {
		return random.nextInt(10);
	}
}