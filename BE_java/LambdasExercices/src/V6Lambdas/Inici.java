package V6Lambdas;

import java.util.ArrayList;
import java.util.List;

public class Inici {

	public static void main(String[] args) {
		
		Integer total = new Flujo<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
				.filtrar((valor)->valor %2 == 0)
				.transformar(valor->valor*valor)
				;
		
		
		
	}
	
}