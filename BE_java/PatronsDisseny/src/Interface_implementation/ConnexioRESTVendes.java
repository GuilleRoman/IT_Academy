package Interface_implementation;

import Interface.IConnectionREST;

public class ConnexioRESTVendes implements IConnectionREST {

	@Override
	public void llegirURL(String url) {
		System.out.println("�rea vendes, Conectant-se a "+url);
	}

}
