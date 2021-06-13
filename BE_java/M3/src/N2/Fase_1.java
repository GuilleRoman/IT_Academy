package N2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Fase_1 {
	
	public static Scanner lector = new Scanner(System.in);
	private static double [][] notesAlumnes = new double [5][4];
	
	
	/**
	 * main 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 2 Fase 1 \n");
			
		//omplirNotes();
		demanarNotes();
		mostrarNotes();

	}
	
	/**
	 * demanarNotes
	 * 
	 * Demana tres notes per alumne, calcula la mitja de les notes
	 * i emmagatzema notes i mitja a l'array notesAlumnes.
	 * 
	 */
	public static void demanarNotes() {
		for(int i=0;i<notesAlumnes.length;i++) {	
			System.out.println("------------------------------");
			for(int j=0;j<notesAlumnes[0].length-1;j++) {
				System.out.print("Alumne "+i+" ");
				System.out.print("   nota : "+j+" : ");
				notesAlumnes[i][j] = demanarDouble();
			}
			// Calculo la mitja
			notesAlumnes[i][notesAlumnes[0].length-1]= calcularMitja(i);
			System.out.println("- Mitja de la nota : "+notesAlumnes[i][notesAlumnes[0].length-1]);
		}		
	}
	
	/**
	 * demanarDouble
	 * 
	 * Recull per teclat un valor de tipus double, el qual
	 * retorna com a resultat de la funció.
	 * 	 
	 * @return	valor	double		
	 */
	public static double demanarDouble() {
		double valor = 0;
		Boolean valorReal = false;
		Boolean iterar = true;
		
		while (iterar) {
			try {
				valor = lector.nextDouble();
				iterar=false;
			} catch (InputMismatchException ex) {
				System.out.print("Valor incorrecte, torna a introduir la nota (9,99) : ");
				lector.next();
			}
		}
		
		return valor;		
	}
	
	
	/**
	 * mostrarNotes
	 * 
	 * Mostra per pantalla les notes dels alumnes, 
	 * així com la seva mitja i informa de si estan
	 * aprovats o suspesos.
	 * 
	 */
	public static void mostrarNotes() {
		System.out.println("\nInforme de les notes de tots els alumnes :");
		for(int i=0;i<notesAlumnes.length;i++) {
			System.out.print("Alumne "+i+" Notes: ");
			
			for(int j=0;j<notesAlumnes[0].length-1;j++) {				
				System.out.print(notesAlumnes[i][j]+" ");				
			}
			
			if (notesAlumnes[i][notesAlumnes[i].length-1] >= 5) {
				System.out.print(" l' alumne ha aprovat amb una nota de ");
			}else {
				System.out.print(" l' alumne ha suspès amb una nota de ");
			}			
			System.out.print(notesAlumnes[i][notesAlumnes[i].length-1]);
			System.out.println();
		}
	}
	
	
	/**
	 * OmplirNotes
	 * 
	 * Funció que genera i introdueix valor reals aleatoris 
	 * a l'array notesAlumnes per comprobar el seu funcionament
	 * sense tenir que introduir notes via teclat.
	 * 
	 */
	public static void omplirNotes() {
		//omplim de dades l'array bidimensional
		for(int i=0;i<notesAlumnes.length;i++) {
			for(int j=0;j<notesAlumnes[0].length-1;j++) {
				notesAlumnes[i][j]=aleatoriDouble(0, 10);
			}
			// Calculo la mitja
			notesAlumnes[i][notesAlumnes[0].length-1]= calcularMitja(i);
			
		}
		
		System.out.println("Les notes de prova i les mitjes han estat generades correctament.");
	}
	
	/**
	 * calcularMitja
	 * 
	 * Calcula la mitja de les notes de cada alumne.
	 * 
	 * 
	 * @param 	index		int 	index de l'alumne a l'array notesAlumnes.
	 * @return	mitja		double	Valor de la mitja calculada.
	 */
	public static double calcularMitja(int index) {
		double mitja=0;
		
		for(int i=0; i<notesAlumnes[index].length-1;i++) {
			mitja+=notesAlumnes[index][i];
		}
		
		if(notesAlumnes[index].length-1==0) {
			System.out.println("Error: divisió per zero");
		}else {
			mitja = mitja/(notesAlumnes[index].length-1);
		}
		
		return Math.round(mitja*100.0)/100.0;
	}
	
	
	/**
	 * aleatoriDouble
	 * 
	 * Genera nombres aleatoris de tipus double
	 * dins del rang indicat (max,min).
	 * 
	 * @param min	int 	rang inferior
	 * @param max	int 	rang superior
	 * 
	 * @return	num		double	valor aleatori generat.
	 */
	public static double aleatoriDouble (int min, int max) {
				
		double num=Math.random()*(max-min)+min;
		num = Math.round(num*100.0)/100.0;	   	
		return num;
	}

}
