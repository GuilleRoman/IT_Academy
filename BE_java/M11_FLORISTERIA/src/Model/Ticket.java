package Model;

import java.util.ArrayList;

public class Ticket {
	public ArrayList<Producte> compraActual = new ArrayList<Producte>();
	public ArrayList<Producte> comprasAntiguas = new ArrayList<Producte>();
	private int numeroTicket;
	private static int contadorTickets;
	private double valorTotal;
	
	public Ticket() {
		Ticket.contadorTickets++;
		this.numeroTicket = Ticket.contadorTickets;
	}
	public ArrayList<Producte> getCompraActual() {
		return compraActual;
	}
	public void setCompraActual(ArrayList<Producte> compraActual) {
		this.compraActual = compraActual;
	}
	public ArrayList<Producte> getComprasAntiguas() {
		return comprasAntiguas;
	}
	public void setComprasAntiguas(ArrayList<Producte> comprasAntiguas) {
		this.comprasAntiguas = comprasAntiguas;
	}
	public int getNumero() {
		return numeroTicket;
	}
	public void setNumero(int numero) {
		this.numeroTicket = numero;
	}
	public double getValorTotal() {
		compraActual.stream().forEach(v-> {
			valorTotal+=v.getPreu();
		});
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
