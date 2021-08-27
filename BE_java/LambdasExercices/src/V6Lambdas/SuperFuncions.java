package V6Lambdas;

import java.util.ArrayList;
import java.util.List;

public class SuperFuncions {
	
	
	public static <T> List<T> filtrar(List<T> llista, Predicado<T> predicado){
		List<T> resultat = new ArrayList <>();
		for( T num : llista) {
			if(predicado.test(num)) {
				resultat.add(num);
			}
		}
		
		return resultat;
	}
	
	
	public static <T> List<T> proveir (int size, Proveidor<T> proveidor){
		List<T> resultat = new ArrayList<T>();
		for(int i = 0; i<size; i++) {
			resultat.add(proveidor.obtenir());
		}
		
		return resultat;
	}
	
	
	public static <T, R> List<R> transformar(List<T> llista, Funcio<T, R> funcio){
		List<R> resultat = new ArrayList <>();
		for( T num : llista) {
			resultat.add(funcio.aplicar(num));
		}
		
		return resultat;
	}
	
	
	public static<T> List<T> actuar(List<T> llista, Consumidor<T> consumidor){
		
		for( T num : llista) {
			consumidor.aceptar(num);
		}
		
		return llista;
	}

	public static <T> void consumir(List<T> llista, Consumidor<T> consumidor){
		
		for( T num : llista) {
			consumidor.aceptar(num);
		}
	}

	public static <T> T reduir(List<T> llista, T identitat, OperadorBinario<T> operadorBinari) {
		T total = identitat;
		
		for( T num : llista) {
			total = operadorBinari.aplicar(total, num);
		}
		
		return total;
	}
}
