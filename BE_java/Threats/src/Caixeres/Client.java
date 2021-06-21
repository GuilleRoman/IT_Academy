package Caixeres;

import java.util.Arrays;

public class Client {
	
	private String nom;
	private int[] carroCompra;
	
	
	public Client(String nom, int[] carroCompra) {
		super();
		this.nom = nom;
		this.carroCompra = carroCompra;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nombre) {
		this.nom = nombre;
	}
	public int[] getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}


	@Override
	public String toString() {
		return "Client [nom=" + nom + ", carroCompra=" + Arrays.toString(carroCompra) + "]";
	}
	
	

}
