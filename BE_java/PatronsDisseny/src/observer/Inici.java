package observer;

public class Inici {

	public static void main(String[] args) {
		
		Subject subject = new Subject();
		
		new BinaryObserver(subject);
		new HexeObserver(subject);
		
		System.out.println("Primer canvi d'estat 15");
		subject.setState(15);
		
		System.out.println("Primer canvi d'estat 25");
		subject.setState(25);

	}

}
