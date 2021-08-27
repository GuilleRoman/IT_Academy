package Camisas;

import java.util.ArrayList;
import java.util.List;

public class Inici {
	
	private static List<Camisa> camises = new ArrayList <Camisa>();

	public static void main(String[] args) {
		
		//Afegeixo camises a la col.lecció (talla,color)
		camises.add(new Camisa("M","VERDA"));
		camises.add(new Camisa("L","BLANCA"));
		camises.add(new Camisa("XL","VERDA"));
		camises.add(new Camisa("S","VERMELLA"));
		camises.add(new Camisa("XL","BLAVA"));
		camises.add(new Camisa("L","BLANCA"));
		
		List<Camisa> camisesVermelles = filtrar(camises, 
			    (Camisa c) ­> “VERDA”.equals(c.getColor()));
		
	}
	
	
	

}
