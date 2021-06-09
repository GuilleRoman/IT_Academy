package N2;

import java.util.Scanner;

public class Fase_1 {

	private static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		int alcada=0;
		
		System.out.println("\n-ESCALA DE NÚMEROS ");
		alcada=llegirSencer("Alçada de l'escala de nombres : ");
		dibuixarEscala(alcada);
		
		System.out.println("\n-PIRÀMIDE INVERTIDA ");
		alcada=llegirSencer("Alçada de la piràmide : ");
		piramideInvertida(alcada);
	}
	
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