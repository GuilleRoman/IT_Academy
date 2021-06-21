package FillsParametres;

public class Proces extends Thread {
	private int valor_condicio;
	private String nom;
	
	public Proces(String nom) {
		this.nom = nom;
		//this.valor_condicio=5;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getValor_condicio() {
		return this.valor_condicio;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	
	public void setValor_condicio(int valor) {
		this.valor_condicio=valor;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=valor_condicio;i++) {
			System.out.println(nom+"  "+i+"  "+this.getName());
		}
	}
	
	public void establirValor(int valor) {
		this.valor_condicio=valor;
	}

}
