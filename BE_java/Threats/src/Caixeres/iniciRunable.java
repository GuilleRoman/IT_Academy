package Caixeres;

public class iniciRunable implements Runnable {
	
	private Client client;
	private Caixera caixera;
	private long timeInitial;
	
	public iniciRunable(Client client, Caixera caixera, long timeInitial) {
		this.caixera = caixera;
		this.client = client;
		this.timeInitial = timeInitial;
	}

	public static void main(String[] args) {
		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });

		Caixera caixera1 = new Caixera("Caixera 1");
		Caixera caixera2 = new Caixera("Caixera 2");
		
		long initialTime=System.currentTimeMillis();
		Runnable proces1 = new iniciRunable(client1, caixera1,initialTime);
		Runnable proces2 = new iniciRunable(client2, caixera2,initialTime);
		
		new Thread(proces1).start();
		new Thread(proces2).start();
	}

	@Override
	public void run() {
		this.caixera.processarComanda(this.client,this.timeInitial);
		
	}

}
