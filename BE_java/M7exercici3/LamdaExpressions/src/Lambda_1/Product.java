package Lambda_1;

public class Product {
	// ----- propietats ----------------------------
	private int id;
	private String nom;
	private double preu;
	
	// ----- Constructors ----------------------------
	public Product(int id, String nom, double preu) {
		this.id = id;
		this.nom = nom;
		this.preu = preu;
	}
	
	// ----- Getters, Setters and toString ------------
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getPreu() {
		return preu;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	@Override
	public String toString() {
		return "- Id: "+id+"  Nom : "+nom+"  preu : "+preu;
	}
	
	
	
	
}
