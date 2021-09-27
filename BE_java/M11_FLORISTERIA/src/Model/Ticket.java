package Model;

import java.util.ArrayList;

public class Ticket {
	public ArrayList<Producte> compra = new ArrayList<Producte>();
	private int numeroTicket;
	private static int contadorTickets;
	private double valorTotal;
	
	public Ticket() {
		Ticket.contadorTickets++;
		this.numeroTicket = Ticket.contadorTickets;
	}
	public ArrayList<Producte> getCompraActual() {
		return compra;
	}
	public void setCompraActual(ArrayList<Producte> compraActual) {
		this.compra = compraActual;
	}
	public int getNumero() {
		return numeroTicket;
	}
	public void setNumero(int numero) {
		this.numeroTicket = numero;
	}
	public double getValorTotal() {
		compra.stream().forEach(v-> {
			valorTotal+=v.getPreu();
		});
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
