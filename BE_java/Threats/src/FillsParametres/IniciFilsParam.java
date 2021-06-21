package FillsParametres;

public class IniciFilsParam {

	public static void main(String[] args) {
		Proces fil1 = new Proces("fil_1");
		Proces fil2 = new Proces("fil_2");
		Proces fil3 = new Proces("fil_3");
		
		fil1.setValor_condicio(5);
		fil2.setValor_condicio(8);
		fil3.setValor_condicio(10);
		
		fil1.start();
		fil2.start();
		fil3.start();
	}

}
