package Interface_implementation;

import Interface.IConnection;

public class ConnexioSQLServer implements IConnection{
	private String host;
	private String port;
	private String usuari;
	private String contrasenya;
	
	public ConnexioSQLServer() {
		this.host = "localhost";
		this.port ="3306";
		this.usuari ="root";
		this.contrasenya ="";
	}

	@Override
	public void connectar() {
		System.out.println("Connectat a SQL server");
		
	}

	@Override
	public void desconectar() {
		System.out.println("Desconnectat de SQL Server");
		
	}

}
