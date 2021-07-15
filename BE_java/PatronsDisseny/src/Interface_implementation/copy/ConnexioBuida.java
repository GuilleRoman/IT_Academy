package Interface_implementation.copy;

import Interface.IConnection;

public class ConnexioBuida implements IConnection {

	@Override
	public void connectar() {
		System.out.println("No s ha especificat el proveidor ");
		
	}

	@Override
	public void desconectar() {
		System.out.println("No s ha especificat el proveidor ");
		
	}

	
}
