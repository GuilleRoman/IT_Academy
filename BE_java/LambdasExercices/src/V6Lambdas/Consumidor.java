package V6Lambdas;

@FunctionalInterface
public interface Consumidor<T> {

	void aceptar(T valor);
	
}
