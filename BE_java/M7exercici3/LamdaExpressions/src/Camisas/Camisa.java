package Camisas;

public class Camisa {
	private String talla;
	private String color;
	
	// ----- constructors ---------------------
	public Camisa(String talla, String color) {
		this.color = color;
		this.talla = talla;
	}
	
	// ----- Getters, Setters i toString --------------
	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Camisa [talla=" + talla + ", color=" + color + "]";
	}
	
	

}
