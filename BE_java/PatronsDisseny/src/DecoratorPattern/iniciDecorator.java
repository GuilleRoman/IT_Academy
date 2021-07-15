package DecoratorPattern;


/**
 * 
 * <p>IT Academy BE Java</>
 *
 * @author juanj
 * 
 *<p>Exercici M</p>
 *
 * 15 de jul. 2021
 * 
 * IniciDecorator utilitzarà RedShapeDecorator per decorar objectes Shape.
 */
public class iniciDecorator {

	public static void main(String[] args) {
		
		Shape cercle = new Cercle();
		Shape redCercle = new RedShapeDecorator(new Cercle());
		
		System.out.print("Cercle vora normal ");
		cercle.draw();

		System.out.print("Cercle amb vora vermella  ");
		redCercle.draw();
		
		
	}

}
