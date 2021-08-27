package SuperFuncionsGeneriques.Interfaces;

import java.util.ArrayList;
import java.util.List;

public class Inici {

	public static void main(String[] args) {
		
		// versio Imperativa --------------------------------------------------------------------------- 
		System.out.println("PROGRAMACIÓ IMPERATIVA ----------------------------------------");
		List<Integer> sencers = crearLlista();				//Crear una llista de sencers.
		System.out.println(sencers);
		
		List<Integer> parells = filtrarParells(sencers);	// Filtrem els nombres parells de la llista.
		System.out.println(parells);
		
		List<Integer> quadrats = elevarQuadrat(parells);	// Filtrem els nombres parells de la llista.
		System.out.println(quadrats);
		
		int total = sumarLlista(quadrats);
		System.out.println("La suma dels quadrats és :"+total);
		
		
		
		System.out.println("PROGRAMACIÓ FUNCIONAL con SuperFunciones ----------------------------------------");
		//Interface Predicado
		System.out.print("- Predicado->Parells : " );
		List<Integer> parells1 = SuperFuncions.filtrar(sencers, new Parells());			// Obtenir els nombres parells
		System.out.println(parells1);
		
		System.out.print("- Predicado->Senars : " );
		List<Integer> senars = SuperFuncions.filtrar(sencers, new Senars());			// Obtenir els nombres senars
		System.out.println(senars);
		
		
		// Interface Proveidor.		
		System.out.print("- Proveidor->Aleatori : " );
		List<Integer> sencers1 = SuperFuncions.proveir(10, new Aleatori());				//Crear una llista de sencers.
		System.out.println(sencers1);
		
		System.out.print("- Proveido->Naturals : " );
		List<Integer> sencers2 = SuperFuncions.proveir(10, new Naturals());				//Crear una llista de sencers.
		System.out.println(sencers2);
		
		//Interface Funcio
		System.out.print("- Funcio->Quadrat : " );
		List<Integer> quadrats1 = SuperFuncions.transformar(sencers, new Quadrat());			// Obtenir els nombres parells
		System.out.println(quadrats1);
		
		System.out.print("- Funcio->Doble : " );
		List<Integer> doble = SuperFuncions.transformar(sencers, new Doble());			// Obtenir els nombres parells
		System.out.println(doble);
		
		System.out.print("- Consumidor->Impresor : " );
		SuperFuncions.actuar(doble, new Impresor());
		
		System.out.print("\n- Consumidor->Impresor  sense retornar llista de nombres sencers: " );
		SuperFuncions.consumir(doble, new Impresor());
		
		Integer total1 = SuperFuncions.reduir(parells, 0, new Sumador());
		System.out.println("\nLa suma dels parells és : "+total1);
		
		Integer total2 = SuperFuncions.reduir(senars, 1, new Multiplicador());
		System.out.println("La multiplicació dels senars és : "+total2);
		
		
	}
	
	public static int sumarLlista(List<Integer> llistat) {
		int resultat = 0;
		
		for(int num : llistat) {
			resultat += num; 
		}
		
		return resultat;
	}
	
	
	public static List<Integer> crearLlista(){
		return List.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
	}
	
	public static List<Integer> filtrarParells(List<Integer> llista){
		List<Integer> resultat = new ArrayList<Integer>();
		
		for(Integer num : llista) {
			if(num %2 == 0) {
				resultat.add(num);
			}
		}
		
		return resultat;	
		
	}
	
	public static List<Integer> elevarQuadrat(List<Integer> llista){
		List<Integer> quadrat = new ArrayList<Integer>();
		
		for(Integer num : llista) {
			quadrat.add(num*num);
		}
		
		return quadrat;	
		
	}


}
