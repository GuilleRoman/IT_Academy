package V6Lambdas;

@FunctionalInterface
public interface Predicado<T> {
	Boolean test(T num);
}
