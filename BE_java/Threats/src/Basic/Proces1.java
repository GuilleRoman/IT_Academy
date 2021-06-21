package Basic;

public class Proces1 implements Runnable {
	String nom;
	
	public Proces1(String nom){
		this.nom = nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}

	@Override
	public void run() {
		for(int i=0; i<=10;i++) {
			System.out.println(nom+" contador  "+i);
		}		
	}

}
