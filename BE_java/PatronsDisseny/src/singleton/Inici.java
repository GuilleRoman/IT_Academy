package singleton;

public class Inici {

	public static void main(String[] args) {
		Connexio conn = Connexio.getInstancia();
		conn.connectar();
		conn.desconnectar();
		
		
		/* // Instancia sense singleton 
		PaisDAOImpl dao = new PaisDAOImpl();
		
		for(Object obj : dao.getPaisos()) {
			System.out.println(((Pais) obj).getNom());
		} */
		
		
		PaisDAOImpl dao = PaisDAOImpl.getInstance();
		for(Object obj : dao.getPaisos()) {
			System.out.println(((Pais) obj).getNom());
		}

	}

}
