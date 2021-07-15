package Interface_implementation.copy;

import Interface.IConnectionREST;

public class ConnexioRESTVendes implements IConnectionREST {

	@Override
	public void llegirURL(String url) {
		System.out.println("Àrea vendes, Conectant-se a "+url);
	}

}
