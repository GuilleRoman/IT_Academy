package v0_InterfacesFuncionalsStandars;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Flujo <T> {

	protected  final List<T> llistaValors;
	
	// CONSTRUCTOR ----------------------
	public Flujo(List<T> llistaValors) {
		this.llistaValors = llistaValors;
	}
	
	public Flujo() {
		this.llistaValors=null;
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
	
}
