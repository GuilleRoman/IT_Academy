package factory;

import Interface.FactoryAbstracta;
import Interface.IConnection;
import Interface.IConnectionREST;
import Interface_implementation.ConnexioRESTCompres;
import Interface_implementation.ConnexioRESTNoArea;
import Interface_implementation.ConnexioRESTVendes;

public class ConnectionRESTFactory implements FactoryAbstracta{

	public IConnectionREST getConnectionREST(String area) {
		
		if(area == null ) {
			return new ConnexioRESTNoArea();
		}else if(area.equalsIgnoreCase("VENDES")) {
			return new ConnexioRESTVendes();
		}else if(area.equalsIgnoreCase("COMPRES")) {
			return new ConnexioRESTCompres();			
		}
		
		return new ConnexioRESTNoArea();
		
	}

	@Override
	public IConnection getBD(String motor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IConnectionREST getREST(String area) {
		if(area == null ) {
			return new ConnexioRESTNoArea();
		}else if(area.equalsIgnoreCase("VENDES")) {
			return new ConnexioRESTVendes();
		}else if(area.equalsIgnoreCase("COMPRES")) {
			return new ConnexioRESTCompres();			
		}
		
		return new ConnexioRESTNoArea();
	}
		
}
