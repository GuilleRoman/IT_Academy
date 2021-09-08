package NIVELL_1.Fase3;

public class Fase_3 {

	public static void main(String[] args) {
		
		String original = "juanjo campos";
				
		revoltar rev = (valor)-> girarString(valor);
		System.out.println(original+"  ->  "+rev.reverse(original));
				
	}

	/**
	 * girarString
	 * 
	 * M�tode que torna la mateixa cadena que rep com a par�metre per� a l'inrev�s.
	 * 
	 * @param cadena		String
	 * @return resultat		String
	 */
	public static String girarString(String cadena) {
		String resultat="";
		
		for (int i = cadena.length()-1; i>=0; i--) {
			resultat+=cadena.charAt(i);			
		}
		
		return resultat;
	}
	
	
	
}
