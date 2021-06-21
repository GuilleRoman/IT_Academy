package Basic;

public class Inici {

	public static void main(String[] args) {
		Proces fil1 = new Proces("Fil  1  Thread");
		Proces fil3 = new Proces("Fil  3  Thread");
		Thread fil2 = new Thread(new Proces1("fil2 Runnable"));
		
		fil3.start();
		fil1.start();
		fil2.start();
		

	}

}
