package Caixeres;

public class iniciThread {

	public static void main(String[] args) {
		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });
		
		long initialTime=System.currentTimeMillis();
        CaixeraThreat caixera1 = new CaixeraThreat("Caixera 1", initialTime, client1);
		CaixeraThreat caixera2 = new CaixeraThreat("Caixera 2", initialTime, client2);
		
		caixera1.start();
		caixera2.start();

	}

}
