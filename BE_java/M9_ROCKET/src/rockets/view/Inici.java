package rockets.view;

import java.util.ArrayList;
import java.util.List;

import rockets.domain.Coet;
import rockets.domain.Propulsor;

public class Inici {
		
	private static Propulsor pr1;	//Var per crear els propulsors i afegir-los al List.
	private static List<Propulsor> llistaCoet1 = new ArrayList<Propulsor>(); // llista de propulsors del coet 1
	private static List<Propulsor> llistaCoet2 = new ArrayList<Propulsor>(); // llista de propulsors del coet 2
	
	public static void main(String[] args) {
		
		// Inicialitzem els propulsors del coet 1
		pr1 = new Propulsor(10);
		llistaCoet1.add(pr1);
		pr1 = new Propulsor(30);
		llistaCoet1.add(pr1);
		pr1 = new Propulsor(80);
		llistaCoet1.add(pr1);
		
		// Inicialitzem els propulsors del coet 2
		pr1 = new Propulsor(30);
		llistaCoet2.add(pr1);
		pr1 = new Propulsor(40);
		llistaCoet2.add(pr1);
		pr1 = new Propulsor(50);
		llistaCoet2.add(pr1);
		pr1 = new Propulsor(50);
		llistaCoet2.add(pr1);
		pr1 = new Propulsor(30);
		llistaCoet2.add(pr1);
		pr1 = new Propulsor(10);
		llistaCoet2.add(pr1);
		
		
		Coet coet1 = new Coet("32WESSDS", llistaCoet1);
		Coet coet2 = new Coet("LDSFJA32", llistaCoet2); 
		
		new PantallaPrincipal(coet1, coet2);
		
				
	}

}
