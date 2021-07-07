package ArrayList;

public class Empleado {

	private String nom;
	private int edat;
	private double sou;
	
	
	public Empleado(String nom, int edat, double sou) {
		
		this.nom = nom;
		this.edat = edat;
		this.sou = sou;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getEdat() {
		return edat;
	}


	public void setEdat(int edat) {
		this.edat = edat;
	}


	public double getSou() {
		return sou;
	}


	public void setSou(double sou) {
		this.sou = sou;
	}


	@Override
	public String toString() {
		return "Empleado [nom=" + nom + ", edat=" + edat + ", sou=" + sou + "] \n";
	}


	@Override
	public int compareTo(Object o) {
		int valor = 0;
		Empleado empleat = (Empleado)o;
		
		if (this.sou > empleat.getSou()) {
			valor = 1;
		} else if (this.sou < empleat.getSou()) {
			valor = -1;
		}else {
			valor = 0;
		}
		return valor;
	}
}
