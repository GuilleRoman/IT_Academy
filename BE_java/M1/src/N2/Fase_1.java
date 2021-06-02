package N2;

public class Fase_1 {

	public static void main(String[] args) {
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M1  Nivell 2 \n");
				
		// Declaració de variables
		double varDouble = 3.1415;
		int varSencera;
		float varFloat;
		String cadena;
		String cadena1;
		
		// Conversió de tipus
		varSencera = (int)varDouble;
		varFloat = (float) varDouble;
		cadena = String.valueOf(varDouble);
		cadena1 = Double.toString(varDouble);
		
		//Mostrem resultats
		System.out.println(varDouble+" Double ");
		System.out.println(varSencera+" Integer ");
		System.out.println(varFloat+" Float ");
		System.out.println(cadena+" String valueOf ");
		System.out.println(cadena1+" String Double.toString");
		

	}

}
