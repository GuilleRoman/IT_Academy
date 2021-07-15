package Interface_implementation.copy;

import Interface.IConnection;

public class ConnexioMySQL implements IConnection {

	private String host;
	private String port;
	private String usuari;
	private String contrasenya;
	
	public ConnexioMySQL() {
		this.host = "localhost";
		this.port ="3306";
		this.usuari ="root";
		this.contrasenya ="";		
	}

	@Override
	public void connectar() {
		System.out.println("Connectat a Mysql");
		
	}

	@Override
	public void desconectar() {
		System.out.println("Desconnectat a Mysql");
		
	}
	
	
	
	
	
}
