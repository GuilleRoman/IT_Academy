package m7exercici2;

public class Edifici {

	// propietats---------------------------------------------------------------------
	String nom;
	int plantes;
	int superficie;
	
	// Constructor -------------------------------------------------------------------
	public Edifici(String nom, int plantes, int superficie) {
		super();
		this.nom = nom;
		this.plantes = plantes;
		this.superficie = superficie;
	}
	
	// Getters and Setters -------------------------------------------------------------

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPlantes() {
		return plantes;
	}

	public void setPlantes(int plantes) {
		this.plantes = plantes;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "Edifici: " + nom + "\n plantes : " + plantes + "\n superficie: " + superficie + "\n";
	}
	
	//Mètodes ---------------------------------------------------------------------------------------
	
	public void netejar() {
		int superficie = this.getSuperficie();
		int plantes = this.getPlantes();	
		
		double tempsNeteja=(superficie/5)*1;
		double tempsPlantes=
				
				
				
				
				
				
				
				
	}
	

}
