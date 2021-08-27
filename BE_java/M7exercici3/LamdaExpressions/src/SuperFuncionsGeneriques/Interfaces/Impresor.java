package SuperFuncionsGeneriques.Interfaces;

public class Impresor implements Consumidor {

	@Override
	public void aceptar(int valor) {
		System.out.print(valor+" ");		
	}
	

}
