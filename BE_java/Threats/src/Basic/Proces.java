package Basic;

public class Proces extends Thread {
	private String nom;
	
	public Proces(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void run () {
		for(int i=0; i<=10;i++) {
			System.out.println(nom+" contador  "+i);
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	
	
}
