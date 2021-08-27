package lambdaApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaApp {

	public static void main(String[] args) {
		ordenar();
		calcularPromig();

	}
	
	public static void calcularPromig() {
		/*Operacio op = new Operacio(){
			@Override
			public double calcularPromedi(double n1, double n2) {
				return (n1+n2)/2;
			}
			
		};
		
		System.out.print("El promig entre 4 i 16 és : "+op.calcularPromedi(4, 16));*/
		
		Operacio op = (double x, double y) -> (x+y)/2;
		System.out.println("El promig entre 4 i 16 és de : "+op.calcularPromedi(4, 16));		
	}
	
	
	public static void ordenar() {
		List<String> llista = new ArrayList<String>();
		llista.add("Antena");
		llista.add("Cibernarium");
		llista.add("Roc");
		llista.add("Boronat");
		llista.add("Barcelona");
		
		/** Collections.sort(llista, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}			
		});*/
		
		// Expressió Lambda (String p1, String p2) -> p1.compareTo(p2)
		Collections.sort(llista,(String p1, String p2) -> p1.compareTo(p2));
		
		for(String element : llista) {
			System.out.println("- "+element);
		}
		
	}
}
