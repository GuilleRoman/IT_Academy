package singleton;

import java.util.ArrayList;
import java.util.List;

public class PaisDAOImpl {
	
	public static PaisDAOImpl instancia = null;
	public static List<Pais> paisos = null;
	
	
	// constructor privat per evitar instancies
	private PaisDAOImpl() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static PaisDAOImpl getInstance() {
		if(instancia == null) {
			instancia = new PaisDAOImpl();
		}
		
		return instancia;
	}
	
	/**
	 * 
	 * @return
	 */
	public  List<Pais> getPaisos() {
		if(paisos == null) {				
			paisos = new ArrayList<Pais>();
		
			Pais p1 = new Pais("CATALUNYA");
			Pais p2 = new Pais("FRANÇA");
			Pais p3 = new Pais("ANGLATERRA");
			
			paisos.add(p1);
			paisos.add(p2);
			paisos.add(p3);
		}
		
		return paisos;
	}
}
