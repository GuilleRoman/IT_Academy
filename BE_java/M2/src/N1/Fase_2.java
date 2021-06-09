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
		 * Mostra la llista de caracters i el tipus de caràcter que és.
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
						System.out.println(" Els noms de persones no contenen números!");
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
		 * Determina si el caracter passat com a paràmetre és
		 * vocal,consonant o un número.
		 * 
		 * @param caracter	(char)
		 * 
		 * 
		 * 
		 * @return	char	'v'	vocal
		 * 					'c' consonant
		 * 					'n'	número
		 */
		public static char tipusChar(char caracter) {
			
			// Strings amb els patrons de vocals,consonants i numèrics.
			String vocals = "aeiou";
			String consonants = "bcdfghijklmnopqrstuvwxyz";
			String numero="1234567890";
			char resultat = 0;
			
			// Passem a minúscules els caracters abans de comparar
			char caracterMin=Character.toLowerCase(caracter);
			
			// Determinem si és vocal, consonant o número.			
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
