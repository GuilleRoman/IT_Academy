package V6Lambdas;

@FunctionalInterface
public interface Funcio<T, R> {
	R aplicar(T num);
}
