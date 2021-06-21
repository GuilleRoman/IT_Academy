package Caixeres;

public class Caixera {
	
	private String nom;
	
	
	public Caixera(String nom) {
		this.nom = nom;
	}
	
	
	public void processarComanda(Client client, long timeStamp) {
		
		//currentTimeMillis() method returns the current time in milliseconds. 
		System.out.println("La caixera " + this.nom + 
				" Comença a processar la compra del client " + client.getNom() + 
				" temps inici: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");

		for (int i = 0; i < client.getCarroCompra().length; i++) { 
				this.esperarXsegundos(client.getCarroCompra()[i]); 
				System.out.println("Procesant el producte " + (i + 1) +  
				" ->Temps: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
				"seg");
		}

		System.out.println("La caixera " + this.nom + " ha finalitzat el processament " + 
				client.getNom() + " EN EL TIEMPO: " + 
				(System.currentTimeMillis() - timeStamp) / 1000 + "seg");		
		
		
	}
	
	
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * 
	 * @param segundos
	 */
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	

}
