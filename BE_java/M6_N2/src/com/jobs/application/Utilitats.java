package com.jobs.application;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * <p>IT Academy BE Java</>
 *
 * @author Juan José Campos Caballero
 * 
 *<p>Exercici M7 Vehicles</p>
 *
 * jul. 2021
 */
public class Utilitats {
	
	public static Scanner lector = new Scanner(System.in);
	
	public Utilitats() {}
	
	
	/**
	 * llegir sencer
	 * 		max	límit màxim
	 * 		min límit mínim
	 * 		
	 * @return	sencer	int
	 */
	public static int llegirSencer(int max, int min) {
		Boolean iterar=true;
		int sencer=0;
		
		do {
			//Determinem que s'ha inserit un nombre de tipus sencer
			try {
				sencer = lector.nextInt();
				iterar=false;
			}catch(InputMismatchException ime) {
				System.out.println("El número inserit no és un nombre sencer : ");
				iterar=true;				
			}
			
			//Determinem si el rang és correcte
			if(sencer < min || sencer >max) { 
				System.out.println("El nombre ha d'estar inclòs al rang  ["+min+" .. "+max+"]");
				iterar=true;
			}
			
			if(iterar) {
				System.out.print("Torna a introduir-lo :");				
			}
			
			lector.nextLine(); //netejem el buffer
			
		}while(iterar);
				
		return sencer;		
	}
	
	/**
	 *demanarReal 
	 * 
	 * @param min		double
	 * @param max		double
	 * @param positiu	boolean
	 * 
	 * @return	double
	 */
	public static  double demanarReal(double min, double max,Boolean positiu) {
		Boolean iterar=true;
		double doble=0;
		
		do {
			//Determinem que s'ha inserit un nombre de tipus double
			try {
				doble = lector.nextDouble();
				iterar=false;
			}catch(InputMismatchException ime) {
				System.out.println("El número inserit no és un nombre real : ");
				iterar=true;				
			}
			
			//Determinem que sigui major de zero
			if(positiu & doble <= 0) {
				System.out.println("El nombre ha de ser major de zero");
				iterar=true;
			}else if(doble < min || doble > max) { //Determinem si el rang del diàmetre és correcte
				System.out.println("El rang del diàmetre ha de ser hi entre [0.4 .. 4] ");
				iterar=true;
			}
			
			if(iterar) {
				System.out.print("Torna a introduir-lo :");				
			}
			lector.nextLine();
		}while(iterar);
		
		
		return doble;
	}
	
}
