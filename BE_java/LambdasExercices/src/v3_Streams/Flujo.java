package v3_Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Flujo <T> {

	private  final List<T> llistaValors;
	
	// CONSTRUCTOR ----------------------
	public Flujo(List<T> llistaValors) {
		this.llistaValors = llistaValors;
	}
	
	

	public List<T> getLlistaValors() {
		return llistaValors;
	}
	
	/** proveir **************************************************
	 * 
	 * @param size
	 * @param proveidor
	 * @return
	 */
	public static <T> Flujo<T> proveir (int size, Supplier<T> proveidor) {
		List<T> resultat = new ArrayList<>();
		
		for(int i=0; i<size;i++) {
			resultat.add(proveidor.get());
		}
		
		return new Flujo<>(resultat);
	}
	
	/** filtrar **************************************************
	 * 
	 * @param predicado
	 * @return
	 */
	public Flujo<T> filtrar(Predicate<T> predicado){
		List<T> resultat = new ArrayList<>();
		
		for( T valor : llistaValors) {
			if(predicado.test(valor)) {
				resultat.add(valor);
			}	
		}		
		
		return new Flujo<>(resultat);
	}
	
	/** transformar ***************************************
	 * 
	 * @param <R>
	 * @param funcio
	 * @return
	 */
	public <R> Flujo<R> transformar(Function<T,R> funcio){
		List<R> resultat = new ArrayList<>();
		
		for( T valor : llistaValors) {
			resultat.add(funcio.apply(valor));			
		}		
		
		return new Flujo<>(resultat);
	}
	
	/** actuar *******************************************
	 * 
	 * @param consumidor
	 * @return
	 */
	public Flujo<T> actuar(Consumer<T> consumidor){
		
		for( T valor : llistaValors) {
			consumidor.accept(valor);
		}	
		
		return new Flujo<>(llistaValors);		
	}
	
	/** consumir **************************************
	 * 
	 * @param consumidor
	 */
	public void consumir (Consumer<T> consumidor){
		
		for( T valor : llistaValors) {
			consumidor.accept(valor);
		}			
	}
	
	
	
	/**
	 * reducir **********************************************************
	 * 
	 * @param identitat
	 * @param operadorBinari
	 * @return
	 */
	public T reducir(T identitat, BinaryOperator<T> operadorBinari) {
		T total = identitat;
		
		for(T valor : llistaValors) {
			total = operadorBinari.apply(total, valor);
		}
		
		return total;
	}
	
	
	/** ordena ********************************************
	 * Ordena la llista i retorna un nou Flujo<T> amb la llista ordenada.
	 * 
	 * @param comparador
	 * @return  Flujo<T>
	 */
	public Flujo<T> ordena(Comparator<T> comparador){
		List<T> novaLlista = new ArrayList<>(llistaValors);
		novaLlista.sort(comparador);
		return new Flujo<>(novaLlista);
		
	}
	
	/** max *************************************************
	 * Retorna el valor màxim de la llista de valors
	 * 
	 * @param comparador
	 * @return	<T>
	 */
	public Optional<T> max(Comparator <T> comparador) {
		
		try {
			return Optional.of(Collections.max(llistaValors, comparador));
		}catch (Exception ex) {
			return Optional.empty();
		}
	}
	
	
}
