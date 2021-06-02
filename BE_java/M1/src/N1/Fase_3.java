package N1;

import java.util.Scanner;

public class Fase_3 {
	
	private static Scanner lector=new Scanner(System.in);
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		int any=1968;
		String missatgeTrue="L'any "+any+" és de traspàs";
		String missatgeFalse="L'any "+any+" no és de traspàs";
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M1  Nivell 1 Fase 3 \n");
		
		//Demanem l'any en format int de quatre dígits.
		any=demanarAny();
		
		//Determinem si és de traspàs
		if(esDeTraspas(any)) {
			System.out.println(missatgeTrue);
		}else {
			System.out.println(missatgeFalse);
		}
	}
	
	/**
	 * anyNeixement
	 * 
	 * @return  valor de l'any    integer
	 */
	public static int demanarAny() {
		String any;
		int valor = 0;
		Boolean iterar = true;
		
		do {
			System.out.print("Insereix l'any : ");
			any=lector.nextLine();
			valor = esSencer(any);
		
			
			//Determinem que l'any és un nombre sencer, de 4 dígits,i >=1948.
			if(valor == -1) {
				System.out.println("El valor inserit no és un nombre sencer ");
			} else if (any.length() != 4) {
				System.out.println("El nombre de dígits de l'any no és correcte");
			} else {
				iterar=false;				
			}
			
		}while(iterar);		
		
		return valor;
	}
		
	
	/**
	 * esDeTraspas
	 * 
	 * any de traspàs (divisible 4 i no divisible per 100 o és divisible per 400)
	 * 
	 * @param any	integer
	 * @return	True: 
	 */
	public static Boolean esDeTraspas(int any) {
		Boolean traspas=false;
			
		if((any%4 == 0 & any%100 != 0) || any%400==0) {
			traspas=true;
		}
		
		return traspas;
	}
	
	
	/**
	 * esSencer 
	 * Realitza un parse de String a integer.
	 * 
	 * @param 	cadena (String) 	Cadena amb el valor
	 * @return	valor (int)			-1 si el parse no es un valor numèric
	 * 								
	 */
	public static int esSencer(String cadena) {
		int valor;	// varible on fem el parse
		
		try {
			valor=Integer.parseInt(cadena);
		}catch(NumberFormatException nfe){
			valor=-1;
		}
		
		return valor;
	}
	
	
	

}
