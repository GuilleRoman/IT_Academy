package N1;

public class Fase_1 {
	
	
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String ctat1, ctat2, ctat3, ctat4, ctat5, ctat6;
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 1 \n");
		
		// Llegim les ciutats i les assignem a les variables
		System.out.print ("Introdueix la ciutat n�m. 1 : ");
		ctat1 = Fase_2.llegirCadena();
		
		System.out.print ("Introdueix la ciutat n�m. 2 : ");
		ctat2 = Fase_2.llegirCadena();
		
		System.out.print ("Introdueix la ciutat n�m. 3 : ");
		ctat3 = Fase_2.llegirCadena();
		
		System.out.print ("Introdueix la ciutat n�m. 4 : ");
		ctat4 = Fase_2.llegirCadena();
		
		System.out.print ("Introdueix la ciutat n�m. 5 : ");
		ctat5 = Fase_2.llegirCadena();
		
		System.out.print ("Introdueix la ciutat n�m. 6 : ");
		ctat6 = Fase_2.llegirCadena();
		
		System.out.println();
		System.out.println("Les ciutats inserides s�n   : "+ctat1+", "+ctat2+", "+ctat3+", "+ctat4+", "+ctat5+", "+ctat6);
				
	}	

}
