package factory;

import Interface.FactoryAbstracta;
import Interface.IConnection;
import Interface.IConnectionREST;

public class Inici {

	public static void main(String[] args) {
		// instancio una fabrica de connexions
		ConnectionBDFactory cf = new ConnectionBDFactory();
		
		IConnection cn1 = cf.getConnexio("MYSQL");
		cn1.connectar();
		cn1.desconectar();
		
		IConnection cn2 = cf.getConnexio("SQL");
		cn2.connectar();
		cn2.desconectar();
		
		IConnection cn3 = cf.getConnexio("hl");
		cn3.connectar();
		cn3.desconectar();
		
		System.out.println("FACTORY ABSTRACT ");
		iniciFactoryAbstract();
	}
	
	
	public static void iniciFactoryAbstract() {
		FactoryAbstracta factoryBD = FactoryProductor.getFactory("BD");
		IConnection cxBD1 = factoryBD.getBD("MYSQL");
		cxBD1.connectar();
		
		FactoryAbstracta factoryREST = FactoryProductor.getFactory("REST");
		IConnectionREST cxBD2 = factoryREST.getREST("REST");
		cxBD2.llegirURL("https://www.youtube.com");
	}

}
