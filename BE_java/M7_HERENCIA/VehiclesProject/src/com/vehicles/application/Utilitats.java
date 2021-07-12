package com.vehicles.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public final class Utilitats {
	
	public static Scanner lector = new Scanner(System.in);
	
	public Utilitats() {}
	
	// ------ INT, DOUBLE, ... -------------------------------------------------------------------------
	/**
	 * llegir sencer
	 * 		max	límit màxim
	 * 		min límit mínim
	 * 		
	 * @return	sencer	int
	 */
	public static int llegirSencer(int min, int max) {
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
	public static  double llegirReal(double min, double max,Boolean positiu) {
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
				System.out.println("El rang del diàmetre ha de ser hi entre [0,4 .. 4] ");
				iterar=true;
			}
			
			if(iterar) {
				System.out.print("Torna a introduir-lo :");				
			}
			lector.nextLine();
		}while(iterar);
		
		
		return doble;
	}
	
	//---- STRING ------------------------------------------------------------------------------------------
	
	/**
	 * llegirString 
	 * Llegeix un String via teclat 
	 * 
	 * @return	str		String
	 */
	public static String llegirString() {
		String str;
		
		do {
			str = lector.nextLine();
		}while (str.equals(""));
		
		return str;
	}
	
	/**
	 * siNo
	 * 
	 * Recull una resposta de si, s o no,n per teclat
	 * 
	 * @return	bool	Boolean 	true	si, s
	 * 								false	no, n
	 */
	public static Boolean siNo() {
		String resposta;
		Boolean bool = null;
		Boolean iterar=true;
		
		while(iterar) {
			resposta = llegirString().toUpperCase();
			
			if(resposta.equals("SI") || resposta.equals("S")) {
				iterar = false;
				bool = true;
			}else if (resposta.equals("NO") || resposta.equals("N")) {
				iterar = false;
				bool = true;
			}			
		}
		
		return bool;
	}
	
	
	
	// ----- DATE ------------------------------------------
	
	/**
	 * LlegirData 
	 * 
	 * Llegir una data en dormat (dd/mm/yyyy)
	 * 
	 * @return	data 	Date
	 */
	public static  Date llegirData() {
		Boolean iterar=true;
		Date data=null;
		Integer dia;
		Integer mes;
		Integer any;
		String dataStr;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		do {			
			try {
				System.out.print("- dia : ");
				dia = llegirSencer(1,31);
				System.out.print("- mes : ");
				mes = llegirSencer(1,12);
				System.out.print("- any : ");
				any = llegirSencer(1900,5000);
				
				dataStr =dia.toString()+"/"+mes.toString()+"/"+any.toString();
				data = sdf.parse(dataStr);
				
				iterar=false;
			}catch(ParseException pee) {
				System.out.println("La data inserida no és correcta, torna a introduir-la : ");
				iterar=true;				
			}			
		}while(iterar);
		
		return data;
	}
	
	/**
	 * stringToDate
	 *  
	 * @param 	str		String
	 * 
	 * @return	data	Date
	 */
	public static Date stringToDate(String str) {
		Date data = null;		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			data = sdf.parse(str);
		} catch (ParseException e) {
			System.out.println("La data passada no és correcta");
			e.printStackTrace();
		}	
		
		return data;
	}
	
	
	
	
}
