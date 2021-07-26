package tamagotchi;

public class Tamagotchi {

	private State estat;
	
	public Tamagotchi() {
		setState(new Aborrit());
	}
	
	public void setState(State estat) {
		this.estat = estat;
		this.estat.setTamagotchi(this);
	}
	
	public void dormint() {
		this.estat.dormir();
	}
	
	public void alimentar() {
		this.estat.alimentar();
	}
	
	public void jugar() {
		this.estat.jugar();
	}
	
	public void comEstas() {
		this.estat.comEstas();
	}
	
	 
	
	
}
