package lambdaApp;
//https://www.youtube.com/watch?v=VLTEPWkEhsg
//https://www.youtube.com/watch?v=VLTEPWkEhsg

@FunctionalInterface
interface Calculator {
	void add(int n1, int n2);
}


class Calc{
	
	public static void afegirAlgunaCosa(int num1, int num2) {
		System.out.println("Mètode Static");
		System.out.println("- El número "+num1+" afegit a "+num2+" en fan : "+num1+num2);
	}
	
	public void afegirNumeros(int num1, int num2) {
		System.out.println("Mètode no Static");
		System.out.println("- El número "+num1+" afegit a "+num2+" en fan : "+(num1+num2));
	}
}

@FunctionalInterface
interface Missatger{
	Missatge getMissatge(String missatge);
}

class Missatge{
	public Missatge(String missatge) {
		System.out.println("Class Missatge constructor :"+missatge);
	}
}

public class MetodesReferencesApp {

	public static void main(String[] args) {
		
		Calc.afegirAlgunaCosa(3, 7);
		
		// 1.- Referència a un mètode Static
		Calculator cRef = Calc::afegirAlgunaCosa;
		cRef.add(7, 3);
		
		//2.- Referpencia a un mètode no Static
		Calc calc = new Calc();
		Calculator cRef1 = calc::afegirNumeros;
		cRef1.add(14, 10);
		
		//3 Referenciar un constructor
		Missatger mRef2 = Missatge :: new;
		mRef2.getMissatge("Search the candle rather than cursing the darkness !! ");
		
		
	}
	
	
	
	
	
	

}
