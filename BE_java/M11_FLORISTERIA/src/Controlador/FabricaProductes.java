package Controlador;

import javax.swing.JOptionPane;

import Model.Arbre;
import Model.Decoracio;
import Model.Flor;
//import Model.Decoracio;
//import Model.Flor;
import Model.Producte;

public class FabricaProductes {
	
	public Producte getProducte(String producte) {
		
		if(producte.equals("arbre")) {					
				return new Arbre(demanarString("Nom de l' arbre: "), demanarDouble("Preu de l'article "), demanarDouble("alçada ") );		
		}else if (producte.equals("flor")) {
				return new Flor(demanarString("Nom de la flor :"), demanarDouble("Preu de l'article "), demanarString("Color :") );
		}else if (producte.equals("decoracio")) {
				return new Decoracio(demanarString("Nom de la decoració :"), demanarDouble("Preu de l'article "),esDeFusta());
		}else {
			return null;
				
		}
		
	}
	
	
	/**
	 * esDeFusta
	 * 
	 * @return	opcioBool	Boolean
	 */
	public Boolean esDeFusta() {
		String opcio="";
		Boolean opcioBool;
		
		do {
			opcio = JOptionPane.showInputDialog("És de fusta (s/n) ? ");
			opcio.toLowerCase();
		}while (!opcio.equals("S") & !opcio.equals("N"));
		
		if (opcio.equals("S")) { 
			opcioBool=true;
		}else {
			opcioBool=false;
		}
		
		return opcioBool;
		
	}
	
	/**
	 * 
	 * @param tipus
	 * @return
	 */
	public String demanarString(String tipus) {
		String nom="";
		do {
			nom = JOptionPane.showInputDialog("Quin és el nom del "+tipus+" : ");
		}while (nom.equals(""));
		
		return nom;
	}
	
	/**
	 * 
	 * @param concepte
	 * @return
	 */
	public double demanarDouble(String concepte) {
		String preu="";
		double preuDouble = 0;
		Boolean esDouble=false;
		
		do {
			preu = JOptionPane.showInputDialog(concepte);
			
			try {
				preuDouble = Double.parseDouble(preu);
				esDouble = true;
			}catch(NumberFormatException nfe){
				esDouble=false;
			}
			
		}while (!esDouble);
		
		return preuDouble;
	}
	
	
}
