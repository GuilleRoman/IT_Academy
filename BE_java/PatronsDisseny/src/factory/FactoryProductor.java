package factory;

import Interface.FactoryAbstracta;

public class FactoryProductor {
	
	public static FactoryAbstracta getFactory(String tipusFactory) {
		
		if(tipusFactory.equalsIgnoreCase("BD")) {
			return new ConnectionBDFactory();
		}else if (tipusFactory.equalsIgnoreCase("REST")) {
			return new ConnectionRESTFactory();
		}
		
		return null;
	}

}
