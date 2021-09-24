package Model;

public class Arbre extends Producte{
	
	private double alçada;

	public Arbre(String nom, double preu) {
		super(nom, preu);	
		Floristeria.contadorArticulos++;
	}
	
	public Arbre(String nom, double preu, double alçada) {
		super(nom, preu);
		this.alçada = alçada;
		Floristeria.contadorArticulos++;
	}

	public double getAlçada() {
		return alçada;
	}

	public void setAlçada(double alçada) {
		this.alçada = alçada;
	}

	@Override
	public String toString() {
		return "alçada=" + alçada ;
	}	
	
	

}
