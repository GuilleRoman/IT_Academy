package Model;

public class Arbre extends Producte{
	
	private double al�ada;

	public Arbre(String nom, double preu) {
		super(nom, preu);	
	}
	
	public Arbre(String nom, double preu, double al�ada) {
		super(nom, preu);
		this.al�ada = al�ada;
	}

	public double getAl�ada() {
		return al�ada;
	}

	public void setAl�ada(double al�ada) {
		this.al�ada = al�ada;
	}

	@Override
	public String toString() {
		return "al�ada=" + al�ada ;
	}	
	
	

}
