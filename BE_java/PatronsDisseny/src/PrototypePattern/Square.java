package PrototypePattern;

public class Square extends Shape {
	
	public Square() {
		type ="quadrat";
	}
	
	@Override
	void draw() {
		System.out.println("insereix un quadrat : : draw() method.");
		
	}
	
}
