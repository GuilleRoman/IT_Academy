package Interface_implementation.copy;

import Interface.IConnectionREST;

public class ConnexioRESTVendes implements IConnectionREST {

	@Override
	public void llegirURL(String url) {
		System.out.println("�rea vendes, Conectant-se a "+url);
	}

}
