package N3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fase_1 {
	public static Scanner lector = new Scanner(System.in);
	private static int[] serieFib;
	
	/**
	 * main 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 3 Fase 1 \n");
		
		System.out.println("CÀLCUL DE LA SEQÜÈNCIA DE FIBONACCI \n");
		System.out.print("Nombre a calcular la seqüència : ");
		fibonacci(demanarSencer());
		mostrarSerie();
	}
	
	/**
	 * 
	 */
	public static void mostrarSerie() {
		for(int i=0;i<serieFib.length;i++) {
			System.out.print(serieFib[i]+" ");
		}
		
	}
	
	
	/**
	 * fibonacci
	 * 
	 * Calcula la seqüència de Fibonnacci del nombre passat com a paràmetre.
	 * 
	 * 
	 * @param num	int 	núm a calcular la seq. de Fibonacci
	 */
	public static void fibonacci(int num) {
		// Dimensiono l'array que contrindrà la sèrie
		serieFib = new int[num];
		
		if (num>2) {
			// Inserim els dos primers termes de la seq.
			serieFib[0] = 0;
			serieFib[1] = 1;
			
			//Calcule de la resta de termes de la seq.
			for(int i=2; i<serieFib.length;i++) {
				serieFib[i] = serieFib[i-1]+serieFib[i-2];				
			}
			
		}else {
			if(num == 1) {
				serieFib[0] = 0;
			}
			
			if (num==2) {
				serieFib[0] = 0;
				serieFib[1] = 1;
			}
		}
		
		
	}
	
	
	
	
	/**
	 * demanarSencer
	 * 
	 * Recull per teclat un valor de tipus int, el qual
	 * retorna com a resultat de la funció.
	 * 	 
	 * @return	valor	int		
	 */
	public static int demanarSencer() {
		int valor = 0;		
		Boolean iterar = true;
		
		while (iterar) {
			try {
				valor = lector.nextInt();
				iterar=false;
			} catch (InputMismatchException ex) {
				System.out.print("Valor incorrecte, torna a introduir un nombre sencer : ");
				lector.next();
			}
		}
		
		return valor;		
	}
}
