package Controlador;

import javax.swing.JOptionPane;

import Model.Arbre;
//import Model.Decoracio;
//import Model.Flor;
import Model.Producte;

public class FabricaProductes {
	
	public Producte getProducte(String producte) {
		switch (producte) {
		case "arbre":					
			return new Arbre(demanarNom("arbre"), demanarPreu());
//			break;
//		case "flor":
//			//return new Flor();
//			break;
//		case "decoracio":
//			//return new Decoracio();
//			break;
		default:
			return null;
		}
	}
	
	public String demanarNom(String tipus) {
		String nom="";
		do {
			nom = JOptionPane.showInputDialog("Quin és el nom del "+tipus+" : ");
		}while (nom.equals(""));
		
		return nom;
	}
	
	public double demanarPreu() {
		String preu="";
		double preuDouble = 0;
		Boolean esDouble=false;
		
		do {
			preu = JOptionPane.showInputDialog("Preu de l'article : ");
			
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
