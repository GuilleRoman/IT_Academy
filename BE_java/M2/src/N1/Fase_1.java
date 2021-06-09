package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_1 {
	
	private static char[] cadena;
	

	public static void main(String[] args) {
		String nom="Lionel Messi";
		cadena=new char [nom.length()];
		
		omplirTaula(nom);
		mostrarTaula(nom.length());
		
	}
	
	
	public static void omplirTaula(String nom) {
		for(int i=0;i<nom.length();i++) {
			cadena[i]=nom.charAt(i);
		}
	}
	
	public static void mostrarTaula(int elem) {
		for(int i=0;i<cadena.length;i++) {
			System.out.print(cadena[i]+" ");
		}
	}
}
