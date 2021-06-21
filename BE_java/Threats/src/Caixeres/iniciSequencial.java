package Caixeres;

public class iniciSequencial {

	public static void main(String[] args) {
		Client client1 = new Client("Client 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Client client2 = new Client("Client 2", new int[] { 1, 3, 5, 1, 1 });

		Caixera caixera1 = new Caixera("Caixera 1");
		Caixera caixera2 = new Caixera("Caixera 2");

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();

		caixera1.processarComanda(client1, initialTime);
		caixera2.processarComanda(client2, initialTime);

	}

}
