package Nivell_3;

public class Alumne {
	//Crea una clase Alumne que tingui com a propietats: Nom, edat, curs i nota.  
	
	private String nom;
	private int edat;
	private String curs;
	private double nota;
	
	// --- CONSTRUCTOR --------------------------------------------
	public Alumne(String nom, int edat, String curs, double nota) {
		super();
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}
	
	//--- GETTERS, SETTERS ToString ---------------------------------
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

	public String getCurs() {
		return curs;
	}

	public void setCurs(String curs) {
		this.curs = curs;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "- nom : " + nom + ", edat : " + edat + ", curs : " + curs + ", nota : " + nota ;
	}
	
	
	

}
