package Interface_implementation;

import Interface.IConnectionREST;

public class ConnexioRESTNoArea implements IConnectionREST {

	@Override
	public void llegirURL(String url) {
		System.out.println("Area no escollida");		
	}
	

}
