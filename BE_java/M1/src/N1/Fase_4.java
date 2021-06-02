package N1;

public class Fase_4 {
	
public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M1  Nivell 1 Fase 4 \n");
				
		// Inicialitzem les variables del nom
		String nom="Lionel";
		String cognom1="Messi";
		String cognom2="Cuccittini";
		String nomSencer=cognom1+" "+cognom2+", "+nom;
		String dataStr;
		
		
		// Mostrem el nom sencer en format cognons, nom	
		System.out.println("El meu nom és "+nomSencer);
		
		// Inicialitzem les variables de la data
		int dia=24;
		int mes=6;
		int any=1987;
		
		dataStr=String.valueOf(dia)+"/";
		dataStr+=String.valueOf(mes)+"/";
		dataStr+=String.valueOf(any);
				
		// Mostrem el nom sencer en format cognons, nom	
		System.out.println("Vaig nèixer el "+dataStr);
		
		//Mostrem si es any de traspàs
		if(esDeTraspas(any)) {
			System.out.println("L'any "+any+" és un any de traspàs");
		}else {
			System.out.println("L'any "+any+" no és un any de traspàs");
		}
		

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
	

}
