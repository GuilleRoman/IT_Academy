package tamagotchi;

import java.util.Scanner;

public class Inici {

	public static void main(String[] args) {
		Tamagotchi meuTamagotchi = new Tamagotchi();
		menu(meuTamagotchi);
		
		

	}
	
	
	public static void menu(Tamagotchi tamagotchi) {
		
		 Scanner scanner = new Scanner(System.in);
		 
	        char opcion;
	        String mensajeOpciones = "Realizar acción: " +
	                "a) alimentar, d) dormir, j) jugar, p) preguntar, s) salir";

	        while (true) {
	            System.out.println(mensajeOpciones);
	            opcion = scanner.next().charAt(0);
	            switch (opcion) {
	                case 'a': tamagotchi.alimentar(); break;
	                case 'd': tamagotchi.dormint(); break;
	                case 'j': tamagotchi.jugar(); break;
	                case 'p': tamagotchi.comEstas(); break;
	                case 's': System.out.println("Hasta pronto!"); System.exit(0);
	                default: System.out.println("Opcion no válida");
	            }
	        }
		
		
		
	}
	

}
