package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_4 {

	private static List<String> llistaCiutats = new ArrayList<String>();	
	
	/**
	 * main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M3  Nivell 1 Fase 4 \n");
		
		// Insereixo les ciutats en un ArrayList
		inserirCiutats();		
		System.out.println("Llista original   : "+llistaCiutats+"\n");
		
		//Creo i dimensiono els arrays de caràcters
		char ciutat1[]=new char [llistaCiutats.get(0).length()];
		char ciutat2[]=new char [llistaCiutats.get(1).length()];
		char ciutat3[]=new char [llistaCiutats.get(2).length()];
		char ciutat4[]=new char [llistaCiutats.get(3).length()];
		char ciutat5[]=new char [llistaCiutats.get(4).length()];
		char ciutat6[]=new char [llistaCiutats.get(5).length()];
		
		//Omplir els arrays de caracters amb les ciutats
		omplirArrayChar(ciutat1, 0);
		omplirArrayChar(ciutat2, 1);
		omplirArrayChar(ciutat3, 2);
		omplirArrayChar(ciutat4, 3);
		omplirArrayChar(ciutat5, 4);
		omplirArrayChar(ciutat6, 5);
		
		//Mostrar ciutats i ciutats girades.
		System.out.print(llistaCiutats.get(0)+" - ");
		mostrarArrayChar(ciutat1);
		
		System.out.print(llistaCiutats.get(1)+" - ");
		mostrarArrayChar(ciutat2);
		
		System.out.print(llistaCiutats.get(2)+" - ");
		mostrarArrayChar(ciutat3);
		
		System.out.print(llistaCiutats.get(3)+" - ");
		mostrarArrayChar(ciutat4);
		
		System.out.print(llistaCiutats.get(4)+" - ");
		mostrarArrayChar(ciutat5);
		
		System.out.print(llistaCiutats.get(5)+" - ");
		mostrarArrayChar(ciutat6);
		
	}
	
	/**
	 * omplirArrayChar
	 * 
	 * Omple array de caràcters desde un String
	 * 
	 * @param ciutat	char[]	Array de caràcters
	 * @param index		int		index de la ciutat a l'ArrayList<String>
	 */
	public static void omplirArrayChar(char ciutat[], int index) {
		for(int i=0;i<llistaCiutats.get(index).length();i++) {
			ciutat[i]=llistaCiutats.get(index).charAt(i);			
		}
	}
	
	/**
	 *  mostrarArrayChar
	 *  
	 *  Mostra per pantalla un array de caràcters.
	 *  
	 * @param ciutat	char[]
	 */
	public static void mostrarArrayChar(char ciutat[]) {
		for(int i=ciutat.length-1;i>=0;i--) {
			System.out.print(ciutat[i]);
		}
		System.out.println();
	}
	
	
	/**
	 * inserirCiutats
	 * 
	 * Afegeix a l'ArrayList les 6 ciutats.
	 */
	public static void inserirCiutats() {
		llistaCiutats.add("Barcelona");
		llistaCiutats.add("Roma");
		llistaCiutats.add("Napoles");
		llistaCiutats.add("Berlin");
		llistaCiutats.add("Lisboa");
		llistaCiutats.add("Paris");
	}
	
	
}
