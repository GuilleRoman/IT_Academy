package V6Lambdas;

import java.util.ArrayList;
import java.util.List;

public class Flujo <T> {

	private final List<T> llistaValors;
	
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
	public Flujo<T> proveir (int size, Proveidor<T> proveidor) {
		List<T> resultat = new ArrayList<>();
		
		for(int i=0; i<size;i++) {
			resultat.add(proveidor.obtenir());
		}
		
		return new Flujo<>(resultat);
	}
	
	/** filtrar **************************************************
	 * 
	 * @param predicado
	 * @return
	 */
	public Flujo<T> filtrar(Predicado<T> predicado){
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
	public <R> Flujo<R> transformar(Funcio<T,R> funcio){
		List<R> resultat = new ArrayList<>();
		
		for( T valor : llistaValors) {
			resultat.add(funcio.aplicar(valor));			
		}		
		
		return new Flujo<>(resultat);
	}
	
	/** actuar *******************************************
	 * 
	 * @param consumidor
	 * @return
	 */
	public Flujo<T> actuar(Consumidor<T> consumidor){
		
		for( T valor : llistaValors) {
			consumidor.aceptar(valor);
		}	
		
		return new Flujo<>(llistaValors);		
	}
	
	/** consumir **************************************
	 * 
	 * @param consumidor
	 */
	public void consumir (Consumidor<T> consumidor){
		
		for( T valor : llistaValors) {
			consumidor.aceptar(valor);
		}			
	}
	
	
	public T reducir(T identitat, OperadorBinario<T> operadorBinari) {
		T total = identitat;
		
		for(T valor : llistaValors) {
			total = operadorBinari.aplicar(total, valor);
		}
		
		return total;
	}
	
	
	
	
	
	
	
}
