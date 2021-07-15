package singleton;

/**
 * 
 * <p>IT Academy BE Java</>
 *
 * @author juanj
 * 
 *<p>Patrons de disseny</p>
 *
 * 14 de jul. 2021
 */
public class Connexio {

	// Declara una variable de tipus static per poder accedir a l'objecte connexió
	// sense tenir que instanciar un nou objecte.
	private static Connexio instancia = null;
	
	//Declara private el constructor per evitar que sigui instanciat.
	private Connexio() {
		
	}
	
	// a través del getInstance obtenim l'accés a la instancia única de l'objecte connexió.
	public static Connexio getInstancia() {
		if(instancia==null) {
			instancia = new Connexio();
		}
		
		return instancia;
	}
	
	
	public void connectar() {
		System.out.println("Connectat a la BD ");
	}
	
	public void desconnectar() {
		System.out.println("Desconnectat de la BD ");
	}
	
}
