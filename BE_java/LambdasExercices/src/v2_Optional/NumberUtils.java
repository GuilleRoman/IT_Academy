package v2_Optional;

public class NumberUtils {

	private NumberUtils() {
		
	}
	
	public static boolean esSenar(int valor) {
		Boolean senar=true;
		
		for (int i=2; i<valor; i++) {
			if(valor %i == 0) {
				senar = false;
			}
		}
		
		return senar;
	}
	
	
	public static int elevarQuadrat(int valor) {
		return valor * valor;
	}
}
