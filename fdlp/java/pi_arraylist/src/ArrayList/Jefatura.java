package ArrayList;

public class Jefatura extends Empleado {
	
	// ------  PROPIETATS  ----------
	private double incentiu;
	
	// ------  CONSTRUCTORS  ----------
	public Jefatura(String nom, int edat, double sou) {
		super(nom,edat,sou);
		this.incentiu=0;
	}
	
	// ------ GETTERS, SETTERS i toString ----------
	public double getIncentiu() {
		return incentiu;
	}
	
	public void setIncentiu(double incentiu) {
		this.incentiu=incentiu;
	}
	
	// ------  MÈTODES  ----------
	public void establirIncentiu(double incentiu) {
		this.incentiu=incentiu;		
	}
	
}
