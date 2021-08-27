package Sencers;

import java.util.ArrayList;
import java.util.List;

public class SuperFuncions {
	
	
	public static List<Integer> filtrar(List<Integer> llista, Predicado predicado){
		List<Integer> resultat = new ArrayList <Integer>();
		for(Integer num : llista) {
			if(predicado.test(num)) {
				resultat.add(num);
			}
		}
		
		return resultat;
	}
	
	
	public static List<Integer> proveir (int size, Proveidor proveidor){
		List<Integer> resultat = new ArrayList<Integer>();
		for(int i = 0; i<size; i++) {
			resultat.add(proveidor.obtenir());
		}
		
		return resultat;
	}
	
	
	public static List<Integer> transformar(List<Integer> llista, Funcio funcio){
		List<Integer> resultat = new ArrayList <Integer>();
		for(Integer num : llista) {
			resultat.add(funcio.aplicar(num));
		}
		
		return resultat;
	}
	
	
	public static List<Integer> actuar(List<Integer> llista, Consumidor consumidor){
		
		for(Integer num : llista) {
			consumidor.aceptar(num);
		}
		
		return llista;
	}

	public static void consumir(List<Integer> llista, Consumidor consumidor){
		
		for(Integer num : llista) {
			consumidor.aceptar(num);
		}
	}

	public static Integer reduir(List<Integer> llista, Integer identitat, FuncioBinaria funcioBinaria) {
		int total = identitat;
		
		for(Integer num : llista) {
			total = funcioBinaria.aplicar(total, num);
		}
		
		return total;
	}
	
	
}
