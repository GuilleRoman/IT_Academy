package N2;

import java.util.Scanner;

public class Fase_1 {

	private static Scanner lector = new Scanner(System.in);
	
	
	/**
	 * main
	 * 
	 * @param args	String[]
	 */
	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M2  Nivell 2 Fase 1 \n");
		System.out.println("\n-ESCALA DE NÚMEROS I PIRÀMIDE INVERTIDA");
		int alcada=0;
		
		System.out.println("\n-ESCALA DE NÚMEROS ");
		alcada=llegirSencer("Alçada de l'escala de nombres : ");
		dibuixarEscala(alcada);
		
		System.out.println("\n-PIRÀMIDE INVERTIDA ");
		alcada=llegirSencer("Alçada de la piràmide : ");
		piramideInvertida(alcada);
	}
	
	/**
	 * llegirSencer
	 * 
	 * LLegeix del teclat un nombre sencer.
	 *  
	 *  
	 * @param missatge	String	Missatge a mostrar abans de llegir el nombre sencer.
	 * 
	 * @return	valor	int		nombre sencer que hem introduit per teclat
	 */
	public static int llegirSencer(String missatge){
        Boolean iterar=true;
        int valor = 0;
                  
         while(iterar){
             System.out.print(missatge);
             
             if(lector.hasNextInt()) {
            	 valor=lector.nextInt();
            	 if(valor>0) {
            		 iterar=false;
            	 }else {
            		 System.out.println("El valor inserit ha de ser positiu.");
            	 }
                 
             }else {
            	 System.out.println("El valor inserit no és un integer.");
             }
         }
         
         return valor;   
	}
	
	/**
	 * dibuixarEscala
	 * 
	 * Dibuixa una escala de números de n pisos i elements.
	 * 
	 * @param alc	int 	alçada de l'escala.
	 */
	public static void dibuixarEscala(int alc) {		
		int inici=1;
		
		for(int i=1;i<=alc;i++) {
			for(int j=1;j<=inici;j++) {
				System.out.print(j);
			}
			System.out.print("\n");
			inici++;
		}
	}
	
	/**
	 * piramideInvertida
	 * Dibuixa una piràmide invertida d'alçada n.
	 * 
	 * 
	 * @param alc	int		Alçada de la piràmide.
	 */
	public static void piramideInvertida(int alc) {
		String cadenaAsteriscs=" ";
		String espais=" ";
		
		int nombre;
		
		for(int i=alc;i>=1;i--){
			
			nombre=i+(i-1);
			
			for(int j=1;j<=nombre;j++){
				cadenaAsteriscs+="*";
			}
			
			System.out.println(cadenaAsteriscs);
			espais+=" ";
			cadenaAsteriscs=espais;
		}		
	}
}