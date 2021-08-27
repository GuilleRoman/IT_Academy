package Sencers;

public class Parells implements Predicado{

	@Override
	public Boolean test(int num) {
		return num %2 ==0;
	}

}
