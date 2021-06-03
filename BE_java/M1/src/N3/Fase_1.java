package N3;

public class Fase_1 {
	
	private static int[] nombres = new int[10];  

	public static void main(String[] args) {
		
		// Capcelera informativa
		System.out.println("IT Academy   BE Java \nExercici M1  Nivell 3 Fase 1 \n");
		
		omplirArray(10);
		
		System.out.print("Array inicial : ");
		mostrarArray(10);
		System.out.println();
		
		tombarArray(10);
		
		System.out.print("Array capgirat : ");
		mostrarArray(10);		
		
	}
	
	/**
	 * omplirArray
	 * 
	 * omple l'array amb sencers consecutius començant en el 1. 
	 * 
	 * @param elements (int) nombre d'elements de l'array
	 */
	public static void omplirArray(int elements) {
		for(int i=0;i<elements;i++) {
			nombres[i]=i+1;
		}
	}

	/**
	 * mostrarArray
	 * 
	 * 
	 * 
	 * @param elements	(int) nombre d'elements de l'array
	 */
	public static void mostrarArray(int elements) {
		for(int i=0;i<elements;i++) {
			System.out.print(nombres[i]+" ");
		}
	}
	
	/**
	 * tombarArray
	 * 
	 * Capgira l'array 
	 * 
	 * @param elem	(int)nombre d'elements de l'array
	 */
	public static void tombarArray(int elem) {
		int menor=0;	 // Límit inferior de l'array
		int major=elem-1; // Límit superior de l'array
		int temp; 	   // Var temporal per moure elements a l'array
		
		while(major-menor>0) {
			temp=nombres[menor];
			nombres[menor]=nombres[major];
			nombres[major]=temp;
			menor++;
			major--;		
			mostrarArray(10);
			System.out.println();
		}
		
	}
	
	
}
