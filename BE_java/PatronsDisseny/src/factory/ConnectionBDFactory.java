package factory;

import Interface.FactoryAbstracta;
import Interface.IConnection;
import Interface.IConnectionREST;
import Interface_implementation.ConnexioBuida;
import Interface_implementation.ConnexioMySQL;
import Interface_implementation.ConnexioSQLServer;

public class ConnectionBDFactory implements FactoryAbstracta {
	
	public IConnection getConnexio(String motor) {
		
		if(motor ==null) {
			return new ConnexioBuida();
		}else if (motor.equalsIgnoreCase("MYSQL")) {	
			return new ConnexioMySQL();
		}else if (motor.equalsIgnoreCase("SQL")) {
			return new ConnexioSQLServer();
		}
		
		return new ConnexioBuida();
	}

	@Override
	public IConnection getBD(String motor) {

		if(motor ==null) {
			return new ConnexioBuida();
		}else if (motor.equalsIgnoreCase("MYSQL")) {	
			return new ConnexioMySQL();
		}else if (motor.equalsIgnoreCase("SQL")) {
			return new ConnexioSQLServer();
		}
		
		return new ConnexioBuida();
	}

	@Override
	public IConnectionREST getREST(String area) {
		// TODO Auto-generated method stub
		return null;
	}	
}
