package SuperFuncionsGeneriques.Interfaces;

public class Parells<T> implements Predicado<T>{

	/*@Override
	public Boolean test(T num) {
		return num % 2 ==0;
	}*/

	@Override
	public Boolean test(T num) {
		int operacio =(int) num % 2;
		return operacio == 0;
	}

}
