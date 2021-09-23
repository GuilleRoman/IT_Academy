package Model;

public class Decoracio extends Producte {
	
	Boolean fusta;
	
	public Decoracio(String nom, double preu) {
		super(nom, preu);		
	}

	public Decoracio(String nom, double preu, Boolean fusta) {
		super(nom, preu);
		this.fusta = fusta;
	}
	
	
	
}
