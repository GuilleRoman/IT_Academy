package Caixeres;

public class CaixeraThreat extends Thread {
	
	private String nom;
	
	private long initialTime;
	
	private Client client;
	
	@Override
	public void run() {		
	
			//currentTimeMillis() method returns the current time in milliseconds. 
			System.out.println("La caixera " + this.nom + 
					" Comença a processar la compra del client " + client.getNom() + 
					" temps inici: " + (System.currentTimeMillis() - this.initialTime) / 1000	+
					"seg");

			for (int i = 0; i < client.getCarroCompra().length; i++) { 
					this.esperarXsegundos(client.getCarroCompra()[i]); 
					System.out.println("Procesant el producte " + (i + 1) +  
					" ->Temps: " + (System.currentTimeMillis() - this.initialTime) / 1000 + 
					"seg");
			}

			System.out.println("La caixera " + this.nom + " ha finalitzat el processament " + 
					client.getNom() + " EN EL TIEMPO: " + 
					(System.currentTimeMillis() - this.initialTime) / 1000 + "seg");		
			
	}
	
	
	
	public CaixeraThreat(String nom, long initialTime, Client client) {
		super();
		this.nom = nom;
		this.initialTime = initialTime;
		this.client = client;
	}



	/**
	 * Getters and Setters
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(long initialTime) {
		this.initialTime = initialTime;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

