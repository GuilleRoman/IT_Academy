package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_1 {
	
	private static char[] cadena;
	

	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M2  Nivell 1 Fase 1 \n");
		
		
		String nom="Lionel Messi";
		cadena=new char [nom.length()];
		
		omplirTaula(nom);
		mostrarTaula(nom.length());
		
	}
	
	/**
	 * omplirTaula
	 * 
	 * Omple l'array cadena (char) amb els caracters continguts
	 * a l'array nom.
	 * 
	 * @param nom	String
	 */
	public static void omplirTaula(String nom) {
		for(int i=0;i<nom.length();i++) {
			cadena[i]=nom.charAt(i);
		}
	}
	
	/**
	 * mostrarTaula
	 * 
	 * Mostra l'array de caracters per pantalla
	 * 
	 * @param 	elem	int	mida de l'array de caracters.
	 */
	public static void mostrarTaula(int elem) {
		for(int i=0;i<cadena.length;i++) {
			System.out.print(cadena[i]+" ");
		}
	}
}
