package Model;

public class Flor extends Producte {
	
	private String color;
	
	public Flor(String nom, double preu) {
		super(nom, preu);
	}

	public Flor(String nom, double preu, String color) {
		super(nom, preu);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "color: " + color;
	}

	
	
	

}
