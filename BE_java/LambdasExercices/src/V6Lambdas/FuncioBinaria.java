package V6Lambdas;

@FunctionalInterface
public interface FuncioBinaria<T, U, R> {

	R aplicar (T valor1, U valor2);
}
