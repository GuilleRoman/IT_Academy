package Interface_implementation.copy;

import Interface.IConnectionREST;

public class ConnexioRESTCompres implements IConnectionREST {

	@Override
	public void llegirURL(String url) {
		System.out.println("�rea de compres, Conectant-se a "+url);
		
	}
	

}
