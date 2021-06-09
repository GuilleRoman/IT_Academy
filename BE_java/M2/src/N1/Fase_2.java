package N1;

import java.util.ArrayList;
import java.util.List;

public class Fase_2 {

			private static List<Character> nomChar = new ArrayList<Character>();
			
		
		/**
		 * main()
		 * 	
		 * @param args
		 */
		public static void main(String[] args) {
			omplirLlista("Lionel Messi 1a 2b");
			mostrarLlista();			
		}
		
		
		public static void omplirLlista(String nom) {
			for(int i=0;i<nom.length();i++) {
				nomChar.add(nom.charAt(i));
			}
		}
		
		
		/**
		 * mostrarLlista
		 * 
		 * Mostra la llista de caracters i el tipus de car�cter que �s.
		 * 
		 */
		public static void mostrarLlista() {
			char resultatChar;
			
			for(int i=0;i<nomChar.size();i++) {
				System.out.print(nomChar.get(i));
				resultatChar=tipusChar(nomChar.get(i));
				
				switch (resultatChar) {
					case 'v':
						System.out.println(" Vocal");
						break;
					case 'c' :
						System.out.println(" Consonant");
						break;
					case 'n' :
						System.out.println(" Els noms de persones no contenen n�meros!");
						break;
					default :
						//System.out.println(" Caracter especial");
						break;
				}
				
			}
		}
		
		
		/**
		 * tipusChar
		 * 
		 * Determina si el caracter passat com a par�metre �s
		 * vocal,consonant o un n�mero.
		 * 
		 * @param caracter	(char)
		 * 
		 * 
		 * 
		 * @return	char	'v'	vocal
		 * 					'c' consonant
		 * 					'n'	n�mero
		 */
		public static char tipusChar(char caracter) {
			
			// Strings amb els patrons de vocals,consonants i num�rics.
			String vocals = "aeiou";
			String consonants = "bcdfghijklmnopqrstuvwxyz";
			String numero="1234567890";
			char resultat = 0;
			
			// Passem a min�scules els caracters abans de comparar
			char caracterMin=Character.toLowerCase(caracter);
			
			// Determinem si �s vocal, consonant o n�mero.			
			if(vocals.indexOf(caracterMin) >= 0) {
				resultat = 'v';
			} else if(consonants.indexOf(caracterMin) >= 0) {
				resultat = 'c';
			}else if(numero.indexOf(caracter) >= 0) {
				resultat = 'n';
			}
			
			return resultat;
		}
		
		
}
