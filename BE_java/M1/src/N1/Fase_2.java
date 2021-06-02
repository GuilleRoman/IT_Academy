package N1;

import java.util.Scanner;

public class Fase_2 {
	
	private static final int anyInicial=1948;
	private static Scanner lector=new Scanner(System.in);
	
	/**
	 * procediment main()
	 * 	
	 * @param args
	 */
	public static void main(String[] args) {
		int quantsTraspas=0;		//Contador dels anys de trasp�s.
		int anyFinal = anyNeixement(); // Demana l'any del teu naixement.
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M1  Nivell 1 Fase 2 \n");
		
		System.out.println("Anys de trasp�s de l'any "+anyInicial+ " fins "+anyFinal);
		
		//Determinem els anys de trasp�s els comptem i els mostrem
		for(int i=anyInicial;i<anyFinal;i++) {
			if(esDeTraspas(i)) {
				quantsTraspas++;
				System.out.print(i+" ");
			}
		}
		
		//Mostrem total
		System.out.println("\nEl nombre d'anys de trasp�s entre "+anyInicial+" i el "+anyFinal+" son :"+quantsTraspas);
		
	}
		
	/**
	 * anyNeixement
	 * 
	 * @return  valor de l'any    integer
	 */
	public static int anyNeixement() {
		String any;
		int valor = 0;
		Boolean iterar = true;
		
		do {
			System.out.print("Any del teu neixement : ");
			any=lector.nextLine();
			valor = esSencer(any);
		
			
			//Determinem que l'any �s un nombre sencer, de 4 d�gits,i >=1948.
			if(valor == -1) {
				System.out.println("El valor inserit no �s un nombre sencer ");
			} else if (any.length() != 4) {
				System.out.println("El nombre de d�gits de l'any no �s correcte");
			} else if(valor < anyInicial) {
				System.out.println("L'any inserit es inferior al 1948 ");
			}else {
				iterar=false;
				
			}
			
		}while(iterar);		
		
		return valor;
	}
	
	/**
	 * esDeTraspas
	 * 
	 * any de trasp�s (divisible 4 i no divisible per 100 o �s divisible per 400)
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
	 * @return	valor (int)			-1 si el parse no es un valor num�ric
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
