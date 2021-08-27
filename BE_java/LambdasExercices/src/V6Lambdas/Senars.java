package V6Lambdas;

public class Senars implements Predicado{

	@Override
	public Boolean test(int num) {		
		return num %2 !=0;
	}
	

}
